package com.quarta_fase.projeto_integrador.usuario.infra.persistence.jpa;

import com.quarta_fase.projeto_integrador.entidade.Usuarios;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuarios, UUID> {

    @Query("SELECT u FROM Usuarios u WHERE u.login = :login")
    Optional<Usuarios> encontrarUsuarioPorLogin(@Param("login") String login);

    void deleteById(@NonNull UUID id);

}
