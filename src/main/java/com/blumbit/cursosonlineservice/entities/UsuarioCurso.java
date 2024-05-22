package com.blumbit.cursosonlineservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class UsuarioCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usucur_id")
    public Integer id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id")
    public Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cur_id")
    public Curso curso;

    @Column(name = "usucur_fecha_registro")
    public LocalDate fechaRegistro;

    @PrePersist
    private void prePersistFechaRegistro(){
        fechaRegistro = LocalDate.now();
    }
}
