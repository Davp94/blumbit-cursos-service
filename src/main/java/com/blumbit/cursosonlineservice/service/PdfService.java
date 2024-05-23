package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.dto.response.CategoriaResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.List;

@Service
public class PdfService {

    private final SpringTemplateEngine springTemplateEngine;

    private final ICategoriaService categoriaService;

    public PdfService(SpringTemplateEngine springTemplateEngine, ICategoriaService categoriaService) {
        this.springTemplateEngine = springTemplateEngine;
        this.categoriaService = categoriaService;
    }

    public File generateCategoriasPdf() throws IOException {
        Context context = getContextCategoriasListPdf();
        String html = loadHtmlTemplate(context);
        String xhtml = convertToXhtml(html);
        return convertToPdf(xhtml);
    }

    private String convertToXhtml(String html){
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setIndentContent(true);
        tidy.setPrintBodyOnly(true);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setShowWarnings(false);
        tidy.setTidyMark(false);

        Document htmlDom = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null);
        OutputStream out = new ByteArrayOutputStream();
        tidy.pprint(htmlDom, out);
        return out.toString();
    }

    private String loadHtmlTemplate(Context context){
        return this.springTemplateEngine.process("index", context);
    }

    private File convertToPdf(String xhtml) throws IOException {
        File file = File.createTempFile("categorias", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(xhtml, new ClassPathResource("/css/").getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContextCategoriasListPdf(){
        List<CategoriaResponse> categoriaResponseList = this.categoriaService.getCategorias();
        Context context = new Context();
        context.setVariable("categorias", categoriaResponseList);
        return context;
    }

}
