package com.quarta_fase.projeto_integrador.usuario.infra.controllers;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import com.quarta_fase.projeto_integrador.usuario.aplication.usecases.AtualizarUsuarioUseCase;
import com.quarta_fase.projeto_integrador.usuario.aplication.usecases.CadastrarUsuarioUseCase;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.PaginaUsuarioResponseDTO;
import com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa.UsuarioRepository;
import com.quarta_fase.projeto_integrador.usuario.infra.controllers.dto.output.CadastrarUsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(CadastrarUsuarioUseCase usuarioUseCase,
                             UsuarioRepository usuarioRepository,
                             AtualizarUsuarioUseCase atualizarUsuarioUseCase) {
        this.cadastrarUsuarioUseCase = usuarioUseCase;
        this.usuarioRepository = usuarioRepository;
        this.atualizarUsuarioUseCase = atualizarUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<CadastrarUsuarioResponseDTO> criar(@RequestBody CadastrarUsuarioResponseDTO usuario) {
        CadastrarUsuarioResponseDTO novoUsuario = cadastrarUsuarioUseCase.cadastrarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<Page<PaginaUsuarioResponseDTO>> listarUsuarios(@PageableDefault(size = 10) Pageable pageable) {
        Page<Usuarios> usuarios = usuarioRepository.buscarUsuarios(pageable);
        Page<PaginaUsuarioResponseDTO> response = usuarios.map(u -> new PaginaUsuarioResponseDTO(u.getId(), u.getLogin(), u.getNome(), u.isInativo()));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaginaUsuarioResponseDTO> atualizarUsuario(
            @PathVariable UUID id,
            @RequestBody PaginaUsuarioResponseDTO usuarioDTO
    ) {
        return ResponseEntity.ok(atualizarUsuarioUseCase.atualizarUsuario(id, usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable UUID id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}