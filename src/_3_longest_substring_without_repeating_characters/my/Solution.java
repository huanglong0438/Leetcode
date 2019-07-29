package _3_longest_substring_without_repeating_characters.my;

import java.util.HashMap;
import java.util.Map;

/**
 * 关键词：滑动窗口
 * 执行用时 :
 * 25 ms
 * , 在所有 Java 提交中击败了
 * 69.82%
 * 的用户
 * 内存消耗 :
 * 39.3 MB
 * , 在所有 Java 提交中击败了
 * 81.29%
 * 的用户
 *
 * @Author: donglongcheng
 * @Description:
 * @Date: Create in 23:19 2019/7/29
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int begin = -1;
        int max = 0;
        Map<Character, Integer> dict = new HashMap<>(s.length());
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!dict.containsKey(c)) {
                dict.put(c, i);
            } else {
                // 注意这里可以控制不要让begin倒车回去了
                begin = Math.max(dict.get(c), begin); // 这里耗时多了，有优化空间
                dict.put(c, i);
            }
            max = Math.max(max, i - begin);
        }
        return max;
    }

}
