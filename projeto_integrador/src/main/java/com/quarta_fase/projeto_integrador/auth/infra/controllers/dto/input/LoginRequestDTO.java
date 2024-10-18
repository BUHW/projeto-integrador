package com.quarta_fase.projeto_integrador.auth.infra.controllers.dto.input;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String login;
    private String password;
}
