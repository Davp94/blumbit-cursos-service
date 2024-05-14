package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.entities.Usuario;
import com.blumbit.cursosonlineservice.repository.UsuariosRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    private final UsuariosRepository usuariosRepository;

    public UserSecurityService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("----------------username--------------------");
        System.out.println(username);
        Usuario usuario = this.usuariosRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException(("Usuario "+username+" no encontrado.")));
        System.out.println(usuario);
        return User.builder()
                .username(usuario.getUsuario())
                .password(usuario.getPassword())
                .accountLocked(false)
                .build();
    }
}
