package com.quarta_fase.projeto_integrador.auth.infra.exception;

public class LoginNaoEncontradoException extends RuntimeException {
    public LoginNaoEncontradoException() {
        super("Login não encontrado");
    }
}
