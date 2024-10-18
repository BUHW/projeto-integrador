package com.quarta_fase.projeto_integrador.usuario.aplication.usecases;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.CadastrarUsuarioResponseDTO;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.mappers.CadastrarUsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuarioUseCase {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CadastrarUsuarioUseCase(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public CadastrarUsuarioResponseDTO cadastrarUsuario(CadastrarUsuarioResponseDTO usuario) {
        Usuarios usuarioEntidade = CadastrarUsuarioMapper.toUsuariosEntidade(usuario);

        usuarioEntidade.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuarios novoUsuario = repository.save(usuarioEntidade);

        return CadastrarUsuarioMapper.toCadastrarUsuarioResponseDTO(novoUsuario);
    }
}
