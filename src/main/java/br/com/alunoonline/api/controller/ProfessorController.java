package br.com.alunoonline.api.controller;


import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201 - Created
    public void criarprofessor(@RequestBody Professor professor) {
        professorService.criarprofessor(professor);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> listarallaluno (){
        return professorService.listarallprof();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200 - OK
    public Optional<Professor> listarporid(@PathVariable Long id){
        return professorService.listarporid(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 - NO CONTENT
    public void deletaralunoporid(@PathVariable Long id){
        professorService.deletarprofporid(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatealunoporid(@PathVariable Long id, @RequestBody Professor profedit){
        professorService.updateprofporid(id, profedit);
    }
}
