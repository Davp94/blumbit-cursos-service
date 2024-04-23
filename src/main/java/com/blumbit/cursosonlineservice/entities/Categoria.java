package com.blumbit.cursosonlineservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Short catId;

    public String catCorrelativo;  // 0000001 - 0000002 - 2024-00001 - 2024-00002

    @Column(length = 100, nullable = true)
    public String catNombre;

    public String catDescripcion;

}
