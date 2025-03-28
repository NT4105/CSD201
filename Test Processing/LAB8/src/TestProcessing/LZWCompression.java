package TestProcessing;

import java.util.*;

public class LZWCompression {
    private Map<String, Integer> dictionary;
    private int dictSize;

    public LZWCompression() {
        dictionary = new HashMap<>();
        dictSize = 0;
        // Initialize dictionary with single characters (ASCII)
        for (int i = 0; i < 128; i++) {
            dictionary.put(String.valueOf((char) i), dictSize++);
        }
    }

    public List<Integer> compress(String text) {
        List<Integer> result = new ArrayList<>();
        String current = "";

        for (char c : text.toCharArray()) {
            String temp = current + c;
            if (dictionary.containsKey(temp)) {
                current = temp;
            } else {
                result.add(dictionary.get(current));
                dictionary.put(temp, dictSize++);
                current = String.valueOf(c);
            }
        }

        if (!current.isEmpty()) {
            result.add(dictionary.get(current));
        }

        return result;
    }

    public Map<String, Integer> getDictionary() {
        return dictionary;
    }
}