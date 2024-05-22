package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.dto.request.AdjuntosRequest;
import com.blumbit.cursosonlineservice.dto.response.AdjuntosResponse;
import com.blumbit.cursosonlineservice.util.FilesDefinition;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class AdjuntosServiceImpl implements IAdjuntosService{
    @Override
    public String create(AdjuntosRequest adjuntosRequest) throws Exception{

        if(validateAdjuntos(adjuntosRequest)){
            String filePath = FilesDefinition.PROJECT_FILES_PATH + File.separator + adjuntosRequest.getTitle();
            byte[] bytes = adjuntosRequest.getFile().getBytes();
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(bytes);
            outputStream.close();
        }else {
            throw new Exception("Formato de imagen no valido");
        }
        return adjuntosRequest.getTitle();
    }

    private boolean validateAdjuntos(AdjuntosRequest adjuntosRequest){
        String contentType = adjuntosRequest.getFile().getContentType();
        if(contentType == null) return false;
        return contentType.equals(MediaType.IMAGE_PNG_VALUE) ||
                contentType.equals(MediaType.IMAGE_JPEG_VALUE);
    }
}
