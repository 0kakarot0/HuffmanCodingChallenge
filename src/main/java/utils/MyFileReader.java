package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MyFileReader {
    private static final String HEADER_END_MARKER = "HEADER_END\n";



    public static byte[] readFileRawByte(String filePath) {
        // Read raw bytes from file
        try {
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] readFileRawByteWithHeader(String filePath) {
        // Read raw bytes from file
        try {
            // Read header and raw bytes from file
            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
            String fileContentStr = new String(fileContent);

            // Find the end of the header
            int headerEndIndex = fileContentStr.indexOf(HEADER_END_MARKER) + HEADER_END_MARKER.length();

            // Extract raw bytes after the header


            return Arrays.copyOfRange(fileContent, headerEndIndex, fileContent.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isEndOfHeader(String currentLine) {
        return currentLine.contains("HEADER_END");
    }
}
