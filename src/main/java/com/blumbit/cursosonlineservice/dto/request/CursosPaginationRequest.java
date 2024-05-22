package com.blumbit.cursosonlineservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CursosPaginationRequest {

    public int page;

    public int size;

    public String sortParam;

    public int order;

    public String nombre;

}
