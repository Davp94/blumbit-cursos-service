package com.blumbit.cursosonlineservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class UsuarioCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usucur_id")
    public Integer id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @Column(name = "usu_id")
    public Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @Column(name = "cur_id")
    public Curso curso;

    @Column(name = "usucur_fecha_registro")
    public LocalDate fechaRegistro;
}
