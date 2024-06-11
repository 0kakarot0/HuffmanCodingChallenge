package huffman_challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class HuffmanTreeConstruction {
    private final Map<Character, Integer> freq = new HashMap<>();
    private final PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();

    public void calcFreq(String str) {
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        System.out.println(freq);
    }

    public MinHeapNode buildHuffmanTree() {
        for (Entry<Character, Integer> entry : freq.entrySet()) {
            minHeap.add(new MinHeapNode(entry.getKey(), entry.getValue()));
        }
        while (minHeap.size() != 1) {
            MinHeapNode left = minHeap.poll();
            MinHeapNode right = minHeap.poll();
            MinHeapNode top = new MinHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            minHeap.add(top);
        }
        return minHeap.peek();
    }

    public PriorityQueue<MinHeapNode> getMinHeap() {
        return minHeap;
    }

    public Map<Character, Integer> getFreq() {
        return freq;
    }
}
