package com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UsuarioResponseDTO {

    private UUID id;
    private String login;
    private String nome;
    private String password;
    private boolean inativo;
}
