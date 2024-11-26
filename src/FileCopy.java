import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Need source file and destination file!");
            return;
        }
        String sourceFile = args[0];
        String targetFile = args[1];
        if (!Files.exists(Paths.get(sourceFile))) {
            System.out.println("Source file does not exist!");
            return;
        }
        if (!Files.exists(Paths.get(targetFile))) {
            System.out.println("Target file does not exist!");
            return;
        }
        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytesCopied = 0;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytesCopied += bytesRead;
            }
            System.out.println("Copy Complete!");
            System.out.println("Bytes copied: " + totalBytesCopied);
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
