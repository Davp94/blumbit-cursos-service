package com.blumbit.cursosonlineservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequest {

    @NotEmpty(message = "El campo no puede ser vacio")
    public String correlativo;

    @NotNull
    @NotBlank
    @Size(max = 100, message = "El campo debe tener una longitud maxima de 100 caracteres")
    public String nombre;

    @NotNull
    @Size(max = 200)
    @Pattern(regexp = "/*^{0,9}/")
    public String descripcion;

    @Email
    public String email;

    @Min(0)
    @Max(100)
    public double price;
}
