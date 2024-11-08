package com.quarta_fase.projeto_integrador.usuario.aplication.usecases;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.UsuarioListResponseDTO;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarUsuarioUseCase {

    private final UsuarioRepository repository;

    @Autowired
    public AtualizarUsuarioUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioListResponseDTO atualizarUsuario(UUID id, UsuarioListResponseDTO usuarioDTO) {
        Optional<Usuarios> usuarioExistente = repository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuarios usuario = usuarioExistente.get();
            usuario.setLogin(usuarioDTO.getLogin());
            usuario.setNome(usuarioDTO.getNome());
            usuario.setInativo(usuarioDTO.isInativo());
            Usuarios usuarioAtualizado = repository.save(usuario);
            return UsuarioMapper.toUsuarioListResponseDTO(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
