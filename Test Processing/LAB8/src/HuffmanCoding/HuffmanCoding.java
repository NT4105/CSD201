/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HuffmanCoding;

import java.util.*;
import java.io.*;

public class HuffmanCoding {
    private Node root = null;
    private Map<Character, Integer> freqMap;
    private Map<Character, String> codeMap;
    private String str;

    public HuffmanCoding process(String str) {
        this.str = str;
        countFreq(str);
        this.root = buildTree(freqMap);
        this.codeMap = new HashMap<>();
        buildCode(root, "");
        return this;
    }

    public String encode() {
        if (this.codeMap == null || this.codeMap.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            builder.append(codeMap.get(c));
        }
        return builder.toString();
    }

    // decoding encoded string based on the Huffman tree
    public String decode(String encoded) {
        Node node = this.root;
        StringBuilder result = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            node = c == '0' ? node.getLeft() : node.getRight();
            if (node.isLeaf()) {
                result.append(node.getCharacter());
                node = root;
            }
        }
        return result.toString();
    }

    private Node buildTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> q = new PriorityQueue<>(freqMap.size(),
                Comparator.comparingInt(Node::getData));
        for (Map.Entry<Character, Integer> i : freqMap.entrySet())
            q.add(new Node(i.getValue(), i.getKey()));
        // Node root = null;
        while (q.size() > 1) {
            Node x = q.poll();
            Node y = q.poll();
            root = new Node(x.getData() + y.getData(), x, y);
            q.add(root);
        }
        return root;
    }

    private void buildCode(Node node, String code) {
        if (node.isLeaf()) {
            codeMap.put(node.getCharacter(), code);
            return;
        }
        buildCode(node.getLeft(), code + "0");
        buildCode(node.getRight(), code + "1");
    }

    private void countFreq(String str) {
        this.freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            int rs = this.freqMap.getOrDefault(c, 0);
            this.freqMap.put(c, rs + 1);
        }
    }

    public HuffmanCoding processFile(String filePath) throws Exception {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return process(content.toString());
    }

    public void printFrequenciesAndCodes() {
        System.out.println("Character | Codeword");
        System.out.println("--------------------");

        // Print characters in order of appearance in the string
        Set<Character> printed = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!printed.contains(c)) {
                String code = codeMap.get(c);
                if (c == ' ') {
                    System.out.printf(" (space)  |   %s%n", code);
                } else {
                    System.out.printf("    %c     |   %s%n", c, code);
                }
                printed.add(c);
            }
        }
    }
}
