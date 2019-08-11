package _5_longest_palindromic_substring;

/**
 * 自研的DP解法
 *
 * @Author: donglongcheng
 * @Description:
 * @Date: Create in 20:52 2019/8/9
 */
public class MyDpSolution {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            // i表示规格
            for(int j = 0; j < s.length() - i; j++){
                if(i == 0){
                    dp[i][j] = true;
                } else if(i == 1) {
                    dp[i][j]= s.charAt(j) == s.charAt(j+1);
                } else {
                    dp[i][j] = s.charAt(j) == s.charAt(j+i) && dp[i-2][j+1];
                }
            }
        }
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = 0; j + i < s.length(); j++) {
                if(dp[i][j]) {
                    return s.substring(j, j + i + 1);
                }
            }
        }
        return "";
    }

}
