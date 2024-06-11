package huffman_challenge;


public class Decoding {
    public String decodeFile(MinHeapNode root, String s) {
        StringBuilder ans = new StringBuilder();
        MinHeapNode curr = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            if (curr.left == null && curr.right == null) {
                ans.append(curr.data);
                curr = root;
            }
        }
        return ans.toString();
    }
}

