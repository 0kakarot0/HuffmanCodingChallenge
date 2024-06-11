package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class MyFileWriter {

    private StringBuilder writeHeaderToFile(Map<Character, String> root) {
        StringBuilder headerContent = new StringBuilder();
        headerContent.append("Character ").append("|").append("Frequencies").append("\n");

        for (Map.Entry<Character, String> current : root.entrySet()) {
            headerContent.append(current.getKey()).append(":").append(current.getValue()).append("\n");
        }

        headerContent.append("*******************************\n");
        headerContent.append("HEADER_END\n");
        return headerContent;
    }



    public void writeFile(Map<Character, String> root, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(writeHeaderToFile(root).toString());
        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, rethrow the exception if you want to handle it further up
            // throw new RuntimeException(e);
        }
    }

    public void writeFileWithoutHeader(byte[] rawBytes, String filePath) throws FileNotFoundException {
        try  {
            // Save raw bytes to file
            Files.write(Paths.get(filePath), rawBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFileWithHeader(Map<Character,String> frequencyMap, byte[] rawBytes, String filePath) throws FileNotFoundException {
        try {
            StringBuilder headerContent = writeHeaderToFile(frequencyMap);
            // Write header and raw bytes to file
            try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
                // Write the header
                outputStream.write(headerContent.toString().getBytes());

                // Write the raw bytes
                outputStream.write(rawBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDecodedTextToFile(String decodedText, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(decodedText);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
