package com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output;

import lombok.Data;

@Data
public class UsuarioLogadoResponseDTO {

    private String login;
    private String nome;
    private String token;
}
