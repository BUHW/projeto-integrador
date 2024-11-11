package com.quarta_fase.projeto_integrador.auth.application.usecases;

import com.quarta_fase.projeto_integrador.auth.infra.exception.LoginInvalidoException;
import com.quarta_fase.projeto_integrador.auth.infra.exception.LoginNaoEncontradoException;
import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.seguranca.infra.TokenService;
import com.quarta_fase.projeto_integrador.auth.infra.controllers.dto.input.LoginRequestDTO;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.UsuarioLogadoResponseDTO;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public LoginUseCase(UsuarioRepository usuarioRepository,
                        PasswordEncoder passwordEncoder,
                        TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public UsuarioLogadoResponseDTO login(LoginRequestDTO usuarioLogadoDTO) {

        Usuarios usuario = usuarioRepository.buscarPorLogin(usuarioLogadoDTO.getLogin())
                .orElseThrow(LoginNaoEncontradoException::new);

        if (passwordEncoder.matches(usuarioLogadoDTO.getPassword(), usuario.getPassword())) {
            String token = tokenService.generateToken(usuario);

            return new UsuarioLogadoResponseDTO(usuario.getLogin(), usuario.getNome(), token);
        }

        throw new LoginInvalidoException();
    }
}
