package com.quarta_fase.projeto_integrador.auth.infra.exception;

public class LoginInvalidoException extends RuntimeException {

    public LoginInvalidoException() {
        super("Login inválido");
    }
}
