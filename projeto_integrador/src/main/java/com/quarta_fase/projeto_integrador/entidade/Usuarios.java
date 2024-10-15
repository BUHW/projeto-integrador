package com.quarta_fase.projeto_integrador.entidade;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
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
}
