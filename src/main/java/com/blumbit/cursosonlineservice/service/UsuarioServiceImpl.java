package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.entities.Usuario;
import com.blumbit.cursosonlineservice.repository.UsuariosRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    private final UsuariosRepository usuariosRepository;

    public UsuarioServiceImpl(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {

        return this.usuariosRepository.save(usuario);
    }
}
