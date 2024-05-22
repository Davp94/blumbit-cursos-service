package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.dto.request.AdjuntosRequest;

public interface IAdjuntosService {
    String create(AdjuntosRequest adjuntosRequest) throws Exception;
}
