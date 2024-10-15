package com.quarta_fase.projeto_integrador.usuario.aplication.usecases;

import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.UsuarioResponseDTO;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CadastrarUsuarioUseCase {

    private final UsuarioRepository repository;

    @Autowired
    public CadastrarUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO cadastrarUsuario(UsuarioResponseDTO usuario) {
        return repository.save(usuario);
    }
}
