package com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.CadastrarUsuarioResponseDTO;

public class CadastrarUsuarioMapper {

    public void CadastrarUsuarioUseCase() {
        throw new UnsupportedOperationException("Essa clase não pode ser instanciada!");
    }

    public static Usuarios toUsuariosEntidade(CadastrarUsuarioResponseDTO usuarioDTO) {
        return Usuarios.builder()
                .login(usuarioDTO.getLogin())
                .nome(usuarioDTO.getNome())
                .password(usuarioDTO.getPassword())
                .build();
    }

    public static CadastrarUsuarioResponseDTO toCadastrarUsuarioResponseDTO(Usuarios usuario) {
        return CadastrarUsuarioResponseDTO.builder()
                .login(usuario.getLogin())
                .nome(usuario.getNome())
                .password(usuario.getPassword())
                .build();
    }
}
