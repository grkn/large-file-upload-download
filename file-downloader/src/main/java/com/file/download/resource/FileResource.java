package com.file.download.resource;

import java.io.InputStream;

public class FileResource {
    private String contentLength;
    private InputStream inputStream;

    public FileResource(String contentLength, InputStream inputStream) {
        this.contentLength = contentLength;
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }
}
