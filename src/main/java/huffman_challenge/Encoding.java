package huffman_challenge;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Encoding {
    private final Map<Character, String> codes = new HashMap<>();

    public void storeCodes(MinHeapNode root, String str) {
        if (root == null) {
            return;
        }
        if (root.data != '$') {
            codes.put(root.data, str);
        }

        if (str.isEmpty()){
            codes.put(root.data, str);
        }
        storeCodes(root.left, str + "0");
        storeCodes(root.right, str + "1");
    }

    public String encode(String content, Map<Character, String> codes) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : content.toCharArray()) {
            encodedString.append(codes.get(c));
        }
        return encodedString.toString();
    }

    public Map<Character, String> getCodes() {
        return codes;
    }
}