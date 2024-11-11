package com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.PaginaUsuarioResponseDTO;
public final class UsuarioMapper {

    private UsuarioMapper(){ throw new RuntimeException("Essa classe não pode ser estanciada"); }

    public static PaginaUsuarioResponseDTO converterPaginaUsuario(Usuarios usuario) {
        return new PaginaUsuarioResponseDTO(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getNome(),
                usuario.isInativo()
        );
    }

    public static Usuarios converterEntidadeUsuario(PaginaUsuarioResponseDTO usuarioDTO) {
        return Usuarios.builder()
                .id(usuarioDTO.getId())
                .login(usuarioDTO.getLogin())
                .nome(usuarioDTO.getNome())
                .inativo(usuarioDTO.isInativo())
                .build();
    }
}
