package dev.hugofaria.brewer.repository;

import dev.hugofaria.brewer.model.Usuario;
import dev.hugofaria.brewer.repository.helper.usuario.UsuariosQueries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByCodigoIn(Long[] codigos);

}