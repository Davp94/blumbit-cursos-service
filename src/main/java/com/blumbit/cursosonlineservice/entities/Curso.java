package com.blumbit.cursosonlineservice.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Short curId;

    public String curNombre;

    public String curDescripcion;

    public String curBanner;

    public Boolean curEstado;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    public Categoria categoria;

/*    @JoinTable(name = "usuario_curso",
    joinColumns = @JoinColumn(name = "usu_id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "cur_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Usuario> usuarios;*/
}
