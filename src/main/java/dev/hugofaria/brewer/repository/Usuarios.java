package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Usuarios extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByEmail(String email);

}