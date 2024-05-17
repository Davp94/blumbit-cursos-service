package com.blumbit.cursosonlineservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Short rolId;

    public String nombre;

    public String rolDescripcion;
}
