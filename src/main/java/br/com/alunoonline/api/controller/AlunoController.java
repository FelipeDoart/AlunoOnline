package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.domain.aluno.Aluno;
import br.com.alunoonline.api.domain.aluno.AlunoService;
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
    public void createAluno(@RequestBody Aluno aluno) {
        alunoService.createAluno(aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listAllAluno (){
        return alunoService.listAllAluno();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200 - OK
    public Optional<Aluno> findByAlunoId(@PathVariable Long id){
        return alunoService.findByAlunoId(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 - NO CONTENT
    public void deleteAlunoByID(@PathVariable Long id){
        alunoService.deleteAlunoByID(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatealunoporid(@PathVariable Long id, @RequestBody Aluno alunoEdit){
        alunoService.updateAluno(id, alunoEdit);
    }
}
