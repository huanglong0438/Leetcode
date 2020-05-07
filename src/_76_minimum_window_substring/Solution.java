package _76_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @title Solution
 * @Description
 * @Author donglongcheng01
 * @Date 2020-05-07
 **/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dictionary = generateDictionary(t);
        int required = dictionary.size();

        int[] ans = new int[]{-1,0,0}; // minSize,left,right
        int left = 0, right = 0;
        int formed = 0;
        Map<Character, Integer> window = new HashMap<>();
        while(right < s.length()) {
            // add to window
            char c = s.charAt(right);
            Integer count = window.getOrDefault(c, 0);
            window.put(c, count+1);

            // update formed
            if(dictionary.containsKey(c) && dictionary.get(c).equals(window.get(c))) {
                formed++;
            }

            while(formed == required && left <= right) {
                updateMinSize(ans, left, right);
                // remove from window
                char poped = s.charAt(left);
                Integer popedCount = window.get(poped);
                window.put(poped, --popedCount);
                // update formed
                if(dictionary.containsKey(poped) && popedCount < dictionary.get(poped)) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]);
    }

    private void updateMinSize(int[] ans, int left, int right) {
        if(ans[0] == -1 || right-left+1 < ans[0]) {
            ans[0] = right-left+1;
            ans[1] = left;
            ans[2] = right + 1;
        }
    }

    private Map<Character, Integer> generateDictionary(String t) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = dictionary.getOrDefault(c, 0);
            dictionary.put(c, count+1);
        }
        return dictionary;
    }
}
