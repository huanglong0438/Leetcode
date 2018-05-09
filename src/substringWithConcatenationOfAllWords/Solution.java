package substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by donglongcheng01 on 2018/5/8.
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        if (s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        for (int i = 0; i < words[0].length(); i++) {
            int left = i;
            int right = i;
            Map<String, Integer> tempMap = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String temp = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordMap.containsKey(temp)) {
                    if (tempMap.containsKey(temp)) {
                        tempMap.put(temp, tempMap.get(temp) + 1);
                    } else {
                        tempMap.put(temp, 1);
                    }
                    while (tempMap.get(temp) > wordMap.get(temp)) {
                        String leftStr = s.substring(left, left + wordLen);
                        tempMap.put(leftStr, tempMap.get(leftStr) - 1);
                        left += wordLen;
                    }
                    if (right - left == totalLen) {
                        result.add(left);
                    }
                } else {
                    // 没有匹配到，前面的全部作废，归零，tempMap清空，left从right重新开始
                    tempMap = new HashMap<>();
                    left = right;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }));
    }

}