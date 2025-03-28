/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 1) Given a set of  characters with frequencies (or probabilities), create the 
Huffman code binary tree. 
2) Calculate frequencies of all characters contained in the text file and create the 
Huffman code binary tree for all characters contained in the text file. 
3) Given a Huffman code tree. Print  codewords of  all leaf nodes. 
 */
package HuffmanCoding;

import java.io.IOException;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String str1 = "Hello World";
        String str2 = "Welcome to Java";

        System.out.println("1.");
        System.out.println("Source: " + str1);

        HuffmanCoding h = new HuffmanCoding().process(str1);
        String encoded = h.encode();
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + h.decode(encoded));

        System.out.println("-------------------------------");
        System.out.println("2.");
        System.out.println("Source: " + str2);

        h = new HuffmanCoding();
        try {
            h.processFile(
                    "c:\\Users\\ACER\\Documents\\CSD201\\Test Processing\\LAB8\\src\\HuffmanCoding\\HuffmanCoding.txt");
            encoded = h.encode();
            System.out.println("Encoded: " + encoded);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("-------------------------------");

        System.out.println("3.");
        System.out.println("Source: " + str1);
        System.out.println("Leaf nodes and their codewords:");

        h = new HuffmanCoding().process(str1);
        h.printFrequenciesAndCodes();
    }

}
