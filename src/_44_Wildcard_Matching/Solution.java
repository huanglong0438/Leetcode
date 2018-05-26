package _44_Wildcard_Matching;

/**
 * Created by donglongcheng01 on 2018/5/26.
 */
public class Solution {

    /**
     * 1808 / 1808 test cases passed.
     *  Status: Accepted
     *  Runtime: 80 ms
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean[] matches = new boolean[s.length() + 1];
        matches[0] = true;
        // 外层遍历pattern，内层遍历s
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) != '*') {
                // 这里要从后往前遍历，是为了不受前面改动的影响
                // 如果从前面遍历，res[i]可能被改动，这样res[i + 1]的结果会受res[i]改动的影响
                // 例如本来匹配*a,是在*匹配的结果基础上，加上a，如果从前开始遍历，就会导致在*a的基础上遍历，成为匹配*aa了
                for (int i = s.length() - 1; i >= 0; i--) {
                    matches[i + 1] = matches[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
                }
            } else {
                int i = 0;
                while (i <= s.length() && !matches[i]) {
                    i++;
                }
                for (; i <= s.length(); i++) {
                    matches[i] = true;
                }
            }
            // 如果p的当前位不是*，那么就不可能和空串匹配了，所以matches[0]就永远是F
            matches[0] = matches[0] && p.charAt(j) == '*';
        }
        return matches[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("adceb", "*a*b"));
    }

}
