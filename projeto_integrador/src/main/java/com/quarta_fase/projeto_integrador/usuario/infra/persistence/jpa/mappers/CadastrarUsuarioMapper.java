package com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class CadastrarUsuarioMapper {

    @Autowired
    public void CadastrarUsuarioUseCase() {
        throw new UnsupportedOperationException("Essa clase não pode ser instanciada!");
    }

    private static UsuarioResponseDTO toCadastrarUsuarioResponseDTO(Usuarios usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .login(usuario.getLogin())
                .nome(usuario.getNome())
                .password(usuario.getPassword())
                .inativo(usuario.isInativo())
                .build();
    }
}
