package com.blumbit.cursosonlineservice.repository;

import com.blumbit.cursosonlineservice.entities.Usuario;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UsuariosRepository extends ListCrudRepository<Usuario, Short> {
    Optional<Usuario> findByUsuario(String usuario);
}
