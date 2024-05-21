package com.blumbit.cursosonlineservice.controller;

import com.blumbit.cursosonlineservice.dto.request.AdjuntosRequest;
import com.blumbit.cursosonlineservice.service.IAdjuntosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/adjuntos")
public class AdjuntosController {
    private final IAdjuntosService adjuntosService;

    public AdjuntosController(IAdjuntosService adjuntosService) {
        this.adjuntosService = adjuntosService;
    }


    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestPart("file")MultipartFile file) throws Exception {
        if(file == null){
            return ResponseEntity.badRequest().body("Error, archivo adjunto necesario");
        }
        return ResponseEntity.ok(this.adjuntosService.create(new AdjuntosRequest(file.getOriginalFilename(), file)));
    }
}
