package com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioLogadoResponseDTO {

    private String login;
    private String nome;
    private String token;
}
