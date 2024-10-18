package com.quarta_fase.projeto_integrador.entidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "i_usuario")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private boolean inativo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void registroCriado() {
        this.createdAt = LocalDateTime.now();
        this.inativo = true;
    }

    @PreUpdate
    protected void registroAtualizado() {
        this.updatedAt = LocalDateTime.now();
    }
}
