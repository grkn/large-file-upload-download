package com.file.download.service;

import com.file.download.resource.FileResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class RestClientService {

    @Value("${uploader.url:http://localhost:8090/context/api/v1/fileRedirect}")
    private String uploadURL;

    public FileResource getFileFromFileUploader() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uploadURL).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setInstanceFollowRedirects(true);
        InputStream inputStream = httpURLConnection.getInputStream();
        String contentLength = httpURLConnection.getHeaderField("Content-Length");
        return new FileResource(contentLength, inputStream);
    }
}
