/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestProcessing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "BABAABAAA";
        
        System.out.println("1) Creating dictionary for LZW encoding:");
        System.out.println("Input string: " + text);
        
        LZWCompression lzw = new LZWCompression();
        List<Integer> compressed = lzw.compress(text);
        
        System.out.println("\nDictionary created during encoding:");
        Map<String, Integer> dict = lzw.getDictionary();
        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            if (entry.getKey().length() > 1 || text.contains(entry.getKey())) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
        
        System.out.println("\n2) Compressed output array (indexes):");
        System.out.println(compressed);
    }
}
