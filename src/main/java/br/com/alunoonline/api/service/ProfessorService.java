package br.com.alunoonline.api.service;


import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public void criarprofessor (Professor professor) {
        professorRepository.save(professor);
    }
    public List<Professor> listarallprof(){
        return professorRepository.findAll();
    }

    public Optional<Professor> listarporid (Long id){
        return professorRepository.findById(id);
    }

    public void deletarprofporid(Long id){
        professorRepository.deleteById(id);
    }
    public void updateprofporid (Long id, Professor profedit){
        profedit.setId(id);
        professorRepository.save(profedit);
    }
}
