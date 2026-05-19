package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void createDisciplina(Disciplina disciplina){
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listAlldisciplina(){
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> listByidDisciplin(Long id){
        return disciplinaRepository.findById(id);
    }

    public void deleteDisciplina(Long id){
        disciplinaRepository.deleteById(id);
    }
    public void updtateDisciplina(Long id, Disciplina disciplinaEdit){
        disciplinaEdit.setId(id);
        disciplinaRepository.save(disciplinaEdit);
    }
}
