package com.blumbit.cursosonlineservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Short catId;

    public String catCorrelativo;  // 0000001 - 0000002 - 2024-00001 - 2024-00002

    @Column(length = 100, nullable = true)
    public String catNombre;

    @Column(columnDefinition = "bool default 1")
    public Boolean estado;

    public String catDescripcion;

    public Short usuarioCreacion;

}
