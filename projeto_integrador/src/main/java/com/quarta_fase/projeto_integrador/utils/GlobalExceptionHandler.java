package com.quarta_fase.projeto_integrador.utils;

import com.quarta_fase.projeto_integrador.utils.exceptions.ModelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ModelException.class)
    public ResponseEntity<Object> handleModelResponse(ModelException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", ex.getMsg());
        response.put("tipo", ex.getTipo());
        response.put("transactionId", ex.getTransactionId());

        HttpStatus status = ex.isSucesso() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        if (!ex.isSucesso()) {
            switch (ex.getTipo()) {
                case "NÃO_ENCONTRADO":
                    status = HttpStatus.NOT_FOUND;
                    break;
                case "NÃO_AUTORIZADO":
                    status = HttpStatus.UNAUTHORIZED;
                    break;
                case "SOLICITAÇÃO_INVÁLIDA":
                    status = HttpStatus.BAD_REQUEST;
                    break;
            }
        }

        return new ResponseEntity<>(response, status);
    }
}
