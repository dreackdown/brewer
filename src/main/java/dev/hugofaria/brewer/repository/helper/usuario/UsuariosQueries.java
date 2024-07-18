package dev.hugofaria.brewer.repository.helper.usuario;

import dev.hugofaria.brewer.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuariosQueries {

     Optional<Usuario> porEmailEAtivo(String email);

     List<String> permissoes(Usuario usuario);

}