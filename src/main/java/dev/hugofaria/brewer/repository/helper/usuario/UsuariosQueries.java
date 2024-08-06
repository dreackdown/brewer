package dev.hugofaria.brewer.repository.helper.usuario;

import dev.hugofaria.brewer.model.Usuario;
import dev.hugofaria.brewer.repository.filter.UsuarioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface UsuariosQueries {

    Optional<Usuario> porEmailEAtivo(String email);

    List<String> permissoes(Usuario usuario);

    Page<Usuario> filtrar(UsuarioFilter filtro, Pageable pageable);

}