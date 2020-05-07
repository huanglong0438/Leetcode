package _5_longest_palindromic_substring;

/**
 * @Author: donglongcheng
 * @Description:
 * @Date: Create in 17:19 2019/8/10
 */
public class MyCenterExternSolution {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        if(s.length() == 1) {
            return s;
        }
        int max_m = 0;
        int max_n = 0;
        int max = 0;
        for(int i = 1; i < s.length() * 2; i++) {
            int m,n,len=0;
            if((i & 1) == 0) {
                // i是偶数，说明中心点在一个字母上
                m = i / 2;
                n = i / 2;
            } else {
                // i是奇数，说明中心点在字母之间
                m = (i - 1) / 2;
                n = (i + 1) / 2;
            }
            while(m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
                m--;
                n++;
                len = n - m;
            }
            if(len > max) {
                max = len;
                max_m = m+1;
                max_n = n-1;
            }
        }
        return s.substring(max_m, max_n + 1);
    }

}
