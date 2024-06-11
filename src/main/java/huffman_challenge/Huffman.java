package huffman_challenge;

import utils.BitStringConverter;
import utils.MyFileReader;
import utils.MyFileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;


public class Huffman {
    private static Encoding encoding;
    private static String fileToReadPath;
    private static String fileToWriteOutputPathNew;
    private static String fileToWriteDecodedOutputPath;
    private static String ENCODED_STRING_PRINT_MESSAGE;
    private static String DECODED_STRING_PRINT_MESSAGE;


    public static void main(String[] args) throws IOException {
        //Initialize the Object & variable
        String content;
        String encodedString;

        // initialize the encoding class object
        encoding = new Encoding();

        // initialize the MyFileWriter class object
        MyFileWriter fileWriter = new MyFileWriter();


        // select files data set
        selectDataSetFile();

        //read file content
        content = readFileContent(fileToReadPath);

        // Create Huffman Tree
        HuffmanTreeConstruction treeConstruction = new HuffmanTreeConstruction();
        treeConstruction.calcFreq(content);
        MinHeapNode root = treeConstruction.buildHuffmanTree();


        //Store the codes and get binary encoded string
        encoding.storeCodes(root, "");
        encodedString = encoding.encode(content, encoding.getCodes());

        //print character with their frequencies
        printCharacterWithFrequencies();

        //print encoded binary String
//        printEncodedString(encodedString);

        //Convert the initial binary into byte array
        byte[] newByteArray = BitStringConverter.binaryStringToBytes(encodedString);

        // Directly convert the byte array into bit string for comparision with bitstring create after reading file
        String newBitString = BitStringConverter.bytesToBinaryString(newByteArray, encodedString.length());


        //write the frequencies table and then raw byte to bin file for compression
        fileWriter.writeFileWithHeader(encoding.getCodes(), newByteArray, fileToWriteOutputPathNew);

        //read the file and fetch the bytes after the header text
        byte[] byteArray = MyFileReader.readFileRawByteWithHeader(fileToWriteOutputPathNew);

        //convert the byte array into bitString
        String bitString = BitStringConverter.bytesToBinaryString(byteArray, encodedString.length());


        //compare the direct bitString and bitString created after reading file
        if (bitString.equals(newBitString)) {
            String variable = "Equal";
            System.out.println(variable);
        }

        // initialize the decoding class object
        Decoding decoding = new Decoding();

        //convert the binary string into text
        String decodedString = decoding.decodeFile(root, bitString);

        //write the decoded String into output file
        fileWriter.writeDecodedTextToFile(decodedString, fileToWriteDecodedOutputPath);


//        printDecodedString();
    }


    private static String readFileContent(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }

    private static void printDecodedString(String decodedString) {
        System.out.println(DECODED_STRING_PRINT_MESSAGE);
        System.out.println(decodedString);
    }

    private static void printEncodedString(String encodedString) {
        System.out.println(ENCODED_STRING_PRINT_MESSAGE);
        System.out.println(encodedString);
    }

    private static void printCharacterWithFrequencies() {
        System.out.println("Character With their Frequencies:");
        for (Entry<Character, String> entry : encoding.getCodes().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void selectDataSetFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 or 2 to select relevant data set");
        int userInput = scanner.nextInt();

        ENCODED_STRING_PRINT_MESSAGE = "\nEncoded Huffman data:";
        DECODED_STRING_PRINT_MESSAGE = "\nDecoded Huffman Data:";

        if (userInput == 1 || userInput == 2) {
            if (userInput == 1) {
                fileToReadPath = "src/main/resources/data_set_one/testDataA.txt";
                fileToWriteOutputPathNew = "src/main/resources/data_set_one/binary_data.bin";
                fileToWriteDecodedOutputPath = "src/main/resources/data_set_one/decodedOutputDataA.txt";
            }
            if (userInput == 2) {
                fileToReadPath = "src/main/resources/data_set_two/testData.txt";
                fileToWriteOutputPathNew = "src/main/resources/data_set_two/binary_data.bin";
                fileToWriteDecodedOutputPath = "src/main/resources/data_set_two/decodedOutputData.txt";

            }
        }
    }

}
