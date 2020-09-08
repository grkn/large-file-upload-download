# large-file-upload-download
 spring file upload, download also redirect file from one service to other service.

## Maven project

run mvn clean install on main pom.xml

## txt-file-generator

.txt file generator generates 1 GB file with name largeFile.txt. You can modify and change the size

1- First step open TxtFileGenerator.java and run main method and create largetFile.txt.
2- Second step open ApplicationMain on file uploader and run main method.
3- Third step open ApplicationMain on file downloader and run main method.


## Open Browser

Type -> http://localhost:8090/ and you can upload large file anytime and it automatically downloads the file after upload.
## Just examine the ram usage it won't increase ram usage only cpu will be effected

Also you can type -> http://localhost:8091/context/api/v1/download to move a large file from one microservice to other microservice without ram usage.










