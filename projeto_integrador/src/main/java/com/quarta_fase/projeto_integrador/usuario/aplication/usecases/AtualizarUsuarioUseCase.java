package com.quarta_fase.projeto_integrador.usuario.aplication.usecases;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.PaginaUsuarioResponseDTO;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers.UsuarioMapper;
import com.quarta_fase.projeto_integrador.utils.exceptions.ModelException;
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
            usuario.setPassword(usuarioDTO.getPassword());
            usuario.setNome(usuarioDTO.getNome());
            usuario.setInativo(usuarioDTO.isInativo());
            return UsuarioMapper.converterPaginaUsuario(usuarioRepository.save(usuario));
        } else {
            throw new ModelException("Usuário não encontrado");
        }
    }
}
