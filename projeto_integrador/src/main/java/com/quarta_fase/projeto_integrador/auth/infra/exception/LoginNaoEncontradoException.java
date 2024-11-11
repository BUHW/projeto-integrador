package com.quarta_fase.projeto_integrador.auth.infra.exception;

import com.quarta_fase.projeto_integrador.utils.exceptions.ModelException;

public class LoginNaoEncontradoException extends ModelException {

    public LoginNaoEncontradoException() {
        super("Login não encontrado");
    }
}
