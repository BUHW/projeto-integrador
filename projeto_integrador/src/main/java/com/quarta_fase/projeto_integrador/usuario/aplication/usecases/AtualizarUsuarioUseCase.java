package com.quarta_fase.projeto_integrador.usuario.aplication.usecases;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.PaginaUsuarioResponseDTO;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AtualizarUsuarioUseCase(UsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    public PaginaUsuarioResponseDTO atualizarUsuario(UUID id, PaginaUsuarioResponseDTO usuarioDTO) {
        Optional<Usuarios> usuarioExistente = usuarioRepository.buscarPorId(id);

        if (usuarioExistente.isPresent()) {
            Usuarios usuario = usuarioExistente.get();
            usuario.setLogin(usuarioDTO.getLogin());
            usuario.setNome(usuarioDTO.getNome());
            usuario.setInativo(usuarioDTO.isInativo());
            Usuarios usuarioAtualizado = usuarioRepository.save(usuario);
            return UsuarioMapper.converterPaginaUsuario(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
