package dev.hugofaria.brewer.security;

import dev.hugofaria.brewer.model.Usuario;
import dev.hugofaria.brewer.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private Usuarios usuarios;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarios.porEmailEAtivo(email);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
        return new UsuarioSistema(usuario, getPermissoes(usuario));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        List<String> permissoes = usuarios.permissoes(usuario);
        permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));

        return authorities;
    }

}