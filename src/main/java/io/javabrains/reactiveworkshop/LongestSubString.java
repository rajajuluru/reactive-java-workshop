package io.javabrains.reactiveworkshop;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcabcbb", LongestStubString = "";
        Map<Character, Integer> LinkedHashMap = new LinkedHashMap<>();
        Integer i = 0, LongestSubStringLength = 0;
        Integer size = s.length();
        for (i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (!LinkedHashMap.containsKey(c)) {
                LinkedHashMap.put(c, i);
            } else {
                i = LinkedHashMap.get(c);
                LinkedHashMap.clear();
            }
            if (LinkedHashMap.size() > LongestSubStringLength) {
                LongestSubStringLength = LinkedHashMap.size();
                LongestStubString = LinkedHashMap.keySet().toString();
            }
        }
        System.out.println("Longest Substring       " + LongestStubString);
        System.out.println("Longest Substring  size     " + LongestSubStringLength);
    }

}
