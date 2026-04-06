package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201 - Created
    public void criarAluno(@RequestBody Aluno aluno) {
        alunoService.criaraluno(aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarallaluno (){
        return alunoService.listarallaluno();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200 - OK
    public Optional<Aluno> listarporid(@PathVariable Long id){
        return alunoService.listarporid(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 - NO CONTENT
    public void deletaralunoporid(@PathVariable Long id){
        alunoService.deletaralunoporid(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatealunoporid(@PathVariable Long id, @RequestBody Aluno alunoEdit){
        alunoService.updatealunoporid(id, alunoEdit);
    }
}
