package dev.hugofaria.brewer.repository.helper.usuario;

import dev.hugofaria.brewer.model.Usuario;
import dev.hugofaria.brewer.repository.filter.UsuarioFilter;

import java.util.List;
import java.util.Optional;


public interface UsuariosQueries {

    public Optional<Usuario> porEmailEAtivo(String email);

    public List<String> permissoes(Usuario usuario);

    public List<Usuario> filtrar(UsuarioFilter filtro);

}