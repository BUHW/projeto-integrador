package com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output;

import lombok.Data;
import java.util.UUID;

@Data
public class PaginaUsuarioResponseDTO {
    private UUID id;
    private String login;
    private String nome;
    private boolean inativo;

    public PaginaUsuarioResponseDTO(UUID id, String login, String nome, boolean inativo) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.inativo = inativo;
    }
}