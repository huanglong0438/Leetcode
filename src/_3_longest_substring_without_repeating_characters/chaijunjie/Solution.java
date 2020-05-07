package _3_longest_substring_without_repeating_characters.chaijunjie;

/**
 * @Author: donglongcheng
 * @Description:
 * @Date: Create in 23:29 2019/7/29
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int [] dp = new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            if(s.substring(l,i).indexOf(s.charAt(i))!=-1)
                // 相当于我的hash撞到了，则把左滑窗直接滑动，这个indexOf不如hash快啊，为啥会比我的快
                l = s.indexOf(s.charAt(i), l)+1; // 他这里因为用了indexOf，相当于滑动完就把hash重置了
            dp[i+1] = Math.max(dp[i], i-l+1); // 持续更新max
        }
        return dp[s.length()];
    }

}
