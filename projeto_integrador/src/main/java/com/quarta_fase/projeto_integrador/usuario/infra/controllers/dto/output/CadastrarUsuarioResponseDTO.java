package com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CadastrarUsuarioResponseDTO {

    private String login;
    private String nome;
    private String password;
}
