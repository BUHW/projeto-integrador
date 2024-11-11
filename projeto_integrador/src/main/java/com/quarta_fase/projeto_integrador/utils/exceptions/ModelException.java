package com.quarta_fase.projeto_integrador.utils.exceptions;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ModelException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public static final String TIPO_ERRO = "Erro";
    public static final String TIPO_SUCESSO = "Sucesso";

    private String msg;
    private String tipo;
    private BigInteger transactionId;
    private boolean sucesso;

    // Construtor para erros
    public ModelException(String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
        this.tipo = TIPO_ERRO;
        this.sucesso = false;
    }

    public ModelException(String msg, String tipo, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
        this.tipo = tipo;
        this.sucesso = false;
    }

    public ModelException(String msg) {
        super(msg);
        this.msg = msg;
        this.tipo = TIPO_ERRO;
        this.sucesso = false;
    }

    public ModelException(String msg, String tipo) {
        super(msg);
        this.msg = msg;
        this.tipo = tipo;
        this.sucesso = false;
    }

    public ModelException(String msg, String tipo, BigInteger transactionId) {
        super(msg);
        this.msg = msg;
        this.tipo = tipo;
        this.transactionId = transactionId;
        this.sucesso = false;
    }

    // Construtor para respostas de sucesso
    public ModelException(String msg, boolean sucesso) {
        super(msg);
        this.msg = msg;
        this.tipo = sucesso ? TIPO_SUCESSO : TIPO_ERRO;
        this.sucesso = sucesso;
    }

    public ModelException(String msg, String tipo, BigInteger transactionId, boolean sucesso) {
        super(msg);
        this.msg = msg;
        this.tipo = tipo;
        this.transactionId = transactionId;
        this.sucesso = sucesso;
    }
}