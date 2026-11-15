package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.domain.usuario.Usuario;
import br.com.alunoonline.api.dtos.DadosAutenticacaoDTO;
import br.com.alunoonline.api.infra.security.DadosTokenJWT;
import br.com.alunoonline.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLoging(@RequestBody @Valid DadosAutenticacaoDTO dados){
        var token = new UsernamePasswordAuthenticationToken
                (dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Usuario)authentication.getPrincipal());
        return  ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
