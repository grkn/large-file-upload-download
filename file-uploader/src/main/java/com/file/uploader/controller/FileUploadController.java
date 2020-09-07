package com.file.uploader.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/context/api/v1")
public class FileUploadController {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException, ServletException {
        Collection<Part> parts = servletRequest.getParts();
        servletResponse.setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
        if (!CollectionUtils.isEmpty(parts)) {
            for (Part part : parts) {
                String fileName = part.getSubmittedFileName();
                servletResponse.setHeader("Content-Disposition", "filename=\"" + fileName + "\"");
                servletResponse.setHeader("Content-Length", String.valueOf(part.getSize()));

                IOUtils.copy(part.getInputStream(), servletResponse.getOutputStream());
            }
        }
    }

    @PostMapping(value = "/fileRedirect")
    public void redirectFile(HttpServletResponse servletResponse) throws IOException {
        File file = new File("largeFile.txt");
        FileInputStream inputStream = new FileInputStream(file);
        servletResponse.setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
        servletResponse.setHeader("Content-Disposition", "filename=\"largeFile.txt\"");
        servletResponse.setHeader("Content-Length", String.valueOf(file.length()));

        IOUtils.copy(inputStream, servletResponse.getOutputStream());

        inputStream.close();
    }
}