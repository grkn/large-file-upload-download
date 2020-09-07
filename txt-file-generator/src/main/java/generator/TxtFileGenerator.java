package generator;

import javax.naming.OperationNotSupportedException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TxtFileGenerator {

    private final static Long SIZE = 1024L * 1024L * 1024L; // 1 GB

    public static void main(String[] args) throws IOException, OperationNotSupportedException {
        createAndWriteToLargeFile(readLoremIpsumText());
    }

    private static String readLoremIpsumText() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("loremipsum.txt");
        byte[] arr = new byte[1024];
        int length = inputStream.read(arr);
        return new String(arr, 0, length);
    }

    private static void createAndWriteToLargeFile(String loremIpsumText) throws IOException, OperationNotSupportedException {
        File file = new File("largeFile.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        while (file.length() < SIZE) {
            System.out.println("File Size : " + file.length());
            outputStream.write(loremIpsumText.getBytes(StandardCharsets.UTF_8));
        }
        outputStream.close();

    }
}
