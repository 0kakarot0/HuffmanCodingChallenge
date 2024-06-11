package utils;

public class BitStringConverter {
    
    // Method to convert binary string to raw bytes
    public static byte[] binaryStringToBytes(String binaryStr) {
        // Ensure the binary string length is a multiple of 8
        int length = binaryStr.length();
        int remainder = length % 8;
        if (remainder != 0) {
            // Pad the binary string with leading zeros to make its length a multiple of 8
            binaryStr = "0".repeat(8 - remainder) + binaryStr;
            length = binaryStr.length();
        }

        int numBytes = length / 8;
        byte[] byteArray = new byte[numBytes];

        for (int i = 0; i < numBytes; i++) {
            // Extract 8-bit segments
            String byteString = binaryStr.substring(8 * i, 8 * (i + 1));
            // Convert 8-bit segment to a byte
            byteArray[i] = (byte) Integer.parseInt(byteString, 2);
        }

        return byteArray;
    }

    // Method to convert raw bytes back to binary string
    public static String bytesToBinaryString(byte[] bytes, int originalLength) {
        StringBuilder binaryString = new StringBuilder();
        for (byte b : bytes) {
            String byteBinaryStr = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            binaryString.append(byteBinaryStr);
        }
        // Remove any padding added during the conversion
        return binaryString.substring(binaryString.length() - originalLength);
    }
}
