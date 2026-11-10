package br.com.alunoonline.api.domain.matriculaAluno;

import br.com.alunoonline.api.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.dtos.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.dtos.DisciplinasAlunoResponseDTO;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponseDTO;
import br.com.alunoonline.api.domain.aluno.Aluno;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class MatriculaAlunoService {
    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    private static final Double MEDIA_PARA_APROVACAO = 7.0;

    public void createMatricula(MatriculaAluno MA){
        MA.setStatus(
                MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(MA);
    }

    // TRANCANDO MATRICULA
    public void lockMatricula(Long id){
        // Buscar Matrícula, caso não exista dará 404(Not Found)
        MatriculaAluno matriculaAluno = matriculaAlunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Trancando

        if (matriculaAluno.getStatus()
                .equals(MatriculaAlunoStatusEnum.MATRICULADO)){
            matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO);
            matriculaAlunoRepository.save(matriculaAluno);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Só é possivel trancar com status MATRICULADO");
        }
    }

    public void updateNotas(Long id, AtualizarNotasRequestDTO dto) {

        // 1) Buscar matrícula (mesmo padrão do trancar)
        MatriculaAluno matricula =
                matriculaAlunoRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Matricula não encontrada"));

        // 2) Só atualiza o que veio preenchido (PATCH parcial!)
        if (dto.getNota1() != null)
            matricula.setNota1(dto.getNota1());
        if (dto.getNota2() != null)
            matricula.setNota2(dto.getNota2());

        // 3) Se as 2 notas existem, calcula média e define status
        if (matricula.getNota1() != null && matricula.getNota2() != null) {

            //Calculo
            Double media = (matricula.getNota1() + matricula.getNota2()) / 2;

            matricula.setStatus(media >= MEDIA_PARA_APROVACAO
                    ? MatriculaAlunoStatusEnum.APROVADO
                    : MatriculaAlunoStatusEnum.REPROVADO);
        }

        // 4) Salvar a matrícula atualizada
        matriculaAlunoRepository.save(matricula);
    }
    public HistoricoAlunoResponseDTO printHistorico(Long alunoId) {

        // 1) Buscar todas as matrículas desse aluno
        List<MatriculaAluno> matriculas = matriculaAlunoRepository.findByAlunoId(alunoId);

        if (matriculas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma matrícula encontrada para esse aluno");
        }
        Aluno aluno = matriculas.get(0).getAluno();

        List<DisciplinasAlunoResponseDTO> disciplinas = new ArrayList<>();

        for (MatriculaAluno matricula : matriculas) {
            DisciplinasAlunoResponseDTO disc = new DisciplinasAlunoResponseDTO();

            disc.setNomeDisciplina(matricula.getDisciplina().getNome());
            disc.setNomeProfessor(matricula.getDisciplina().getProfessor().getNome());
            disc.setNota1(matricula.getNota1());
            disc.setNota2(matricula.getNota2());

            //Calcula a medía apenas quando os dois
            if (matricula.getNota1() != null && matricula.getNota2() != null) {
                Double media = (matricula.getNota1() + matricula.getNota2()) / 2;
                disc.setMedia(media);
            }
            disc.setStatus(matricula.getStatus());
            disciplinas.add(disc);
        }

        // 4) Montar a resposta final e retornar
        HistoricoAlunoResponseDTO historico = new HistoricoAlunoResponseDTO();
        historico.setNomeAluno(aluno.getNome());
        historico.setEmailAluno(aluno.getEmail());
        historico.setCpfAluno(aluno.getCpf());
        historico.setDisciplinas(disciplinas);

        return historico;
    }
}
