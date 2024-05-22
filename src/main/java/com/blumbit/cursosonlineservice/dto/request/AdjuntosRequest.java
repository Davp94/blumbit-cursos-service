package com.blumbit.cursosonlineservice.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class AdjuntosRequest {

    @NotEmpty(message = "El titulo no puede estar vacio")
    @Size(min = 5, max = 100, message = "El titulo de la imagen debe tener entre 5 y 100 caracteres")
    private String title;

    @NotNull(message = "El campo no puede ser nulo")
    private MultipartFile file;
}
