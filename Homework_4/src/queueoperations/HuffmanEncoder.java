package queueoperations;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode {

    char c;
    int frequency;
    HuffmanNode left = null;
    HuffmanNode right = null;

    HuffmanNode(char c, int frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public HuffmanNode(char c, int frequency, HuffmanNode left, HuffmanNode right) {
        this.c = c;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
};

class HuffmanEncoder {

    public static void encode(HuffmanNode root, String input, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.c, input);
        }
        encode(root.left, input + "0", huffmanCode);
        encode(root.right, input + "1", huffmanCode);
    }

    public static void generateCode(String inputString) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (!freq.containsKey(inputString.charAt(i))) {
                freq.put(inputString.charAt(i), 0);
            }
            freq.put(inputString.charAt(i), freq.get(inputString.charAt(i)) + 1);
        }

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>((l, r) -> l.frequency - r.frequency);
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        while (priorityQueue.size() != 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            int sum = left.frequency + right.frequency;
            priorityQueue.add(new HuffmanNode('\0', sum, left, right));
        }
        HuffmanNode root = priorityQueue.peek();
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            stringBuilder.append(huffmanCode.get(inputString.charAt(i)));
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        String input = "It is a sunny day today";
        generateCode(input);
    }
}
