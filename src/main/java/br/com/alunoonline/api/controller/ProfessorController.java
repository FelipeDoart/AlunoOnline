package br.com.alunoonline.api.controller;


import br.com.alunoonline.api.domain.professor.DadosListagemProfessor;
import br.com.alunoonline.api.domain.professor.Professor;
import br.com.alunoonline.api.domain.professor.ProfessorRepository;
import br.com.alunoonline.api.domain.professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;
    @Autowired
    private ProfessorRepository repository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201 - Created
    public void criarprofessor(@RequestBody Professor professor) {
        professorService.criarprofessor(professor);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Professor> listarallaluno (){
//        return professorService.listarallprof();
//    }

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
    @GetMapping
    public ResponseEntity<Page<DadosListagemProfessor>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessor::new);
        return ResponseEntity.ok(page);
    }
}
