package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponseDTO;
import br.com.alunoonline.api.domain.matriculaAluno.MatriculaAluno;
import br.com.alunoonline.api.domain.matriculaAluno.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
public class MatriculaAlunoController {
    @Autowired
    MatriculaAlunoService matriculaAlunoService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMatricula (@RequestBody MatriculaAluno MA){
        matriculaAlunoService.createMatricula(MA);
    }

    @PatchMapping("/trancar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void lockMatricula(@PathVariable Long id){
        matriculaAlunoService.lockMatricula(id);
    }

    @PatchMapping("/atualizar-notas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNotas(@PathVariable Long id, @RequestBody AtualizarNotasRequestDTO dto) {
        matriculaAlunoService.updateNotas(id, dto);
    }
    @GetMapping("/emitir-historico/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoResponseDTO printHistorico(@PathVariable Long alunoId) {
        return matriculaAlunoService.printHistorico(alunoId);
    }
}
