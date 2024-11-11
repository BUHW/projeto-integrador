package com.quarta_fase.projeto_integrador.auth.infra.exception;

import com.quarta_fase.projeto_integrador.utils.exceptions.ModelException;

public class LoginInvalidoException extends ModelException {

    public LoginInvalidoException() {
        super("Login inválido", "NAO_AUTORIZADO");
    }
}
