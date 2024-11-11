package com.quarta_fase.projeto_integrador.auth.infra.controllers;

import com.quarta_fase.projeto_integrador.auth.application.usecases.LoginUseCase;
import com.quarta_fase.projeto_integrador.auth.infra.controllers.dto.input.LoginRequestDTO;
import com.quarta_fase.projeto_integrador.auth.infra.exception.LoginInvalidoException;
import com.quarta_fase.projeto_integrador.auth.infra.exception.LoginNaoEncontradoException;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.UsuarioLogadoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {

    private final LoginUseCase loginUseCase;

    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioLogadoResponseDTO> login(@RequestBody LoginRequestDTO loginDTO) {
        return ResponseEntity.ok(loginUseCase.login(loginDTO));
    }
}
