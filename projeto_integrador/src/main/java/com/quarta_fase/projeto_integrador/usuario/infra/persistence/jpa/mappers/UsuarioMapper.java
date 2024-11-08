package com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.UsuarioListResponseDTO;

public class UsuarioMapper {

    public static UsuarioListResponseDTO toUsuarioListResponseDTO(Usuarios usuario) {
        return new UsuarioListResponseDTO(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getNome(),
                usuario.isInativo()
        );
    }

    public static Usuarios toUsuariosEntity(UsuarioListResponseDTO usuarioDTO) {
        return Usuarios.builder()
                .id(usuarioDTO.getId())
                .login(usuarioDTO.getLogin())
                .nome(usuarioDTO.getNome())
                .inativo(usuarioDTO.isInativo())
                .build();
    }
}
