package com.blumbit.cursosonlineservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequest {

   public String correlativo;

    @NotNull
    @NotBlank
    @Size(max = 10, message = "El campo debe tener una longitud maxima de 10 caracteres")
    public String nombre;

    @NotNull
    @Size(max = 200)
    public String descripcion;

/*    @Email
    public String email;

    @Min(0)
    @Max(100)
    public double price;*/
}
