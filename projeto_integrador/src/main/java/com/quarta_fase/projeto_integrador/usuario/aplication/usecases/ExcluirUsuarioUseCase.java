package com.quarta_fase.projeto_integrador.usuario.aplication.usecases;

import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class ExcluirUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ExcluirUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public boolean excluirLogicamente(UUID id) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setInativo(true);
            usuarioRepository.save(usuario);
            return true;
        }).orElse(false);
    }
}

