package huffman_challenge;

class MinHeapNode implements Comparable<MinHeapNode> {
    char data;
    int freq;
    MinHeapNode left, right;

    MinHeapNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
    }

    public int compareTo(MinHeapNode other) {
        return this.freq - other.freq;
    }
}
