package com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.PaginaUsuarioResponseDTO;
import com.quarta_fase.projeto_integrador.utils.exceptions.ModelException;

public final class UsuarioMapper {

    private UsuarioMapper(){ throw new ModelException("Essa classe não pode ser estanciada"); }

    public static PaginaUsuarioResponseDTO converterPaginaUsuario(Usuarios usuario) {
        return new PaginaUsuarioResponseDTO(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getPassword(),
                usuario.getNome(),
                usuario.isInativo());
    }

    public static Usuarios converterEntidadeUsuario(PaginaUsuarioResponseDTO usuarioDTO) {
        return Usuarios.builder()
                .id(usuarioDTO.getId())
                .login(usuarioDTO.getLogin())
                .password(usuarioDTO.getPassword())
                .nome(usuarioDTO.getNome())
                .inativo(usuarioDTO.isInativo())
                .build();
    }
}
