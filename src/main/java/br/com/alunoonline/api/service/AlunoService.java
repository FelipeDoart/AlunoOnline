package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    public void criaraluno(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarallaluno(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> listarporid (Long id){
        return alunoRepository.findById(id);
    }

    public void deletaralunoporid(Long id){
        alunoRepository.deleteById(id);
    }
    public void updatealunoporid (Long id, Aluno alunoedit){
        alunoedit.setId(id);
        alunoRepository.save(alunoedit);
    }
}
