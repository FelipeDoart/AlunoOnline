package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.domain.disciplina.Disciplina;
import br.com.alunoonline.api.domain.disciplina.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDisciplina (@RequestBody Disciplina disciplina){
        disciplinaService.createDisciplina(disciplina);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> listAlldisciplina(){
        return disciplinaService.listAlldisciplina();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Disciplina> listByidDisciplina (@PathVariable Long id){
        return  disciplinaService.listByidDisciplin(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDisciplina (@PathVariable Long id){
        disciplinaService.deleteDisciplina(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updtateDisciplina(@PathVariable Long id,@RequestBody Disciplina disciplinaEdit){
        disciplinaService.updtateDisciplina(id,disciplinaEdit);
    }
}
