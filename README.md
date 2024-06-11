# Huffman Encoding Challenge

This project implements a Huffman encoding algorithm to compress and decompress text files. The program reads a text file, builds a Huffman tree, creates a frequency table, encodes the text into a binary string, converts the binary string into bytes, writes the data into a `.bin` file with the frequency table as a header, and then decodes the binary data back into the original text.

## Features

1. Read the text file
2. Create a Huffman tree
3. Create a frequency table
4. Create a binary string
5. Convert the binary string into bytes
6. Write the data into a `.bin` file with the frequency table as the header and raw bytes afterward
7. Read the file for the raw bytes
8. Convert the raw bytes into a binary string
9. Decode the binary string into text
10. Write the decoded text into an output file

## How to Use

### Prerequisites

- Java 8 or higher
- Maven (optional, for dependency management)

### Project Structure
```
huffman_challenge/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── huffman_challenge/
│ │ │ │ ├── Huffman.java
│ │ │ │ ├── Encoding.java
│ │ │ │ ├── Decoding.java
│ │ │ │ ├── HuffmanTreeConstruction.java
│ │ │ ├── utils/
│ │ │ │ ├── BitStringConverter.java
│ │ │ │ ├── MyFileReader.java
│ │ │ │ ├── MyFileWriter.java
│ └── resources/
│ ├── data_set_one/
│ │ ├── testDataA.txt
│ ├── data_set_two/
│ │ ├── testData.txt  
└── README.md

```

### Running the Program

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/huffman_challenge.git
    cd huffman_challenge
    ```

2. Compile the program:
    ```sh
    javac -d bin src/main/java/huffman_challenge/*.java src/main/java/utils/*.java
    ```

3. Run the program:
    ```sh
    java -cp bin huffman_challenge.Huffman
    ```

4. Follow the on-screen instructions to select the dataset file.

### Example

1. Select the dataset by entering `1` or `2` when prompted.

2. The program will display the characters with their frequencies, encode the text, and write the compressed data into a `.bin` file.

3. The program will then read the `.bin` file, decode the data, and write the decoded text into an output file.

## Classes and Methods

### Huffman.java

- `main(String[] args)`: Entry point of the program.
- `readFileContent(String filePath)`: Reads the content of the specified file.
- `printDecodedString(String decodedString)`: Prints the decoded string.
- `printEncodedString(String encodedString)`: Prints the encoded binary string.
- `printCharacterWithFrequencies()`: Prints the characters with their frequencies.
- `selectDataSetFile()`: Prompts the user to select a dataset file.

### Encoding.java

Handles the encoding process, including storing codes and encoding the text.

### Decoding.java

Handles the decoding process, including decoding the binary string back into the original text.

### HuffmanTreeConstruction.java

Builds the Huffman tree and calculates the frequencies of characters.

### BitStringConverter.java

Utility class for converting between binary strings and byte arrays.

### MyFileReader.java

Utility class for reading files, including extracting raw bytes from a file with a header.

### MyFileWriter.java

Utility class for writing files, including writing the frequency table and raw bytes to a `.bin` file and writing the decoded text to an output file.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For questions or suggestions, please open an issue or contact me at [your-email@example.com](mailto:your-email@example.com).

