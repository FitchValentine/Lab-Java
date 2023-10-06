import java.util.HashMap;
import java.util.Map;

public class SubstringWithUniqueCharacters1 {
    public static String findLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        while (end < n) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(charIndexMap.get(currentChar) + 1, start);
            }

            charIndexMap.put(currentChar, end);
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
            }

            end++;
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        String longestSubstring = findLongestSubstring(input);
        System.out.println("Longest substring with unique characters: " + longestSubstring);
    }
}