package com.quarta_fase.projeto_integrador.usuario.infra.controllers;

import com.quarta_fase.projeto_integrador.usuario.aplication.usecases.CadastrarUsuarioUseCase;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.CadastrarUsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    @Autowired
    public UsuarioController(CadastrarUsuarioUseCase usuarioUseCase){
        this.cadastrarUsuarioUseCase = usuarioUseCase;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastrarUsuarioResponseDTO> criar(@RequestBody CadastrarUsuarioResponseDTO usuario) {
        CadastrarUsuarioResponseDTO novoUsuario = cadastrarUsuarioUseCase.cadastrarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }
}
