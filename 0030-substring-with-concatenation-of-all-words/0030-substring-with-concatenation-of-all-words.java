
import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        if (words.length == 0) return ans;

        int wordLen = words[0].length();
        int totalWords = words.length;

        // Required frequency of words
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Try every possible offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            Map<String, Integer> seen = new HashMap<>();

            for (int right = offset;
                 right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // If word is not required
                if (!wordCount.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                // Add current word
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                // Shrink if frequency becomes greater than required
                while (seen.get(word) > wordCount.get(word)) {

                    String leftWord = s.substring(left, left + wordLen);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    count--;
                    left += wordLen;
                }

                // All required words found
                if (count == totalWords) {

                    ans.add(left);

                    // Remove first word to search for overlapping windows
                    String leftWord = s.substring(left, left + wordLen);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    count--;
                    left += wordLen;
                }
            }
        }

        return ans;
    }
}
