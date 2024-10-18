package com.quarta_fase.projeto_integrador.seguranca.infra;

import com.quarta_fase.projeto_integrador.auth.infra.exception.LoginNaoEncontradoException;
import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UsuarioRepository repository;

    @Autowired
    public CustomUserDetailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Usuarios user = this.repository.encontrarUsuarioPorLogin(login)
                .orElseThrow(LoginNaoEncontradoException::new);

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                new ArrayList<>());
    }

}
