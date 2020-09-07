package com.file.download.controller;

import com.file.download.resource.FileResource;
import com.file.download.service.RestClientService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/context/api/v1")
public class FileDownloadController {

    private final RestClientService restClientService;

    public FileDownloadController(RestClientService restClientService) {
        this.restClientService = restClientService;
    }

    @GetMapping(value = "/download")
    public void downloadFile(HttpServletResponse servletResponse) throws IOException {
        FileResource fileResource = restClientService.getFileFromFileUploader();
        servletResponse.setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
        servletResponse.setHeader("Content-Disposition", "filename=\"largeFile.txt\"");
        servletResponse.setHeader("Content-Length", fileResource.getContentLength());

        IOUtils.copy(fileResource.getInputStream(), servletResponse.getOutputStream());
    }

}
