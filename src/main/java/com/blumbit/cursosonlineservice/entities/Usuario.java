package com.blumbit.cursosonlineservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usu_id")
    public Short id;

    @Column(name = "usu_usuario", unique = true)
    public String usuario;

    @Column(length = 100, nullable = true, name = "usu_password")
    public String password;

    @Column(name = "usu_avatar")
    public String avatar;

    @Column(name = "usu_is_locked")
    public Boolean isLocked;

    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    public Rol rol;

/*    @ManyToMany(mappedBy = "usuarios")
    public List<Curso> cursos;*/

}
