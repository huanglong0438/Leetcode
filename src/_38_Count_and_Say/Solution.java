package _38_Count_and_Say;

/**
 * Created by donglongcheng01 on 2018/5/15.
 */
public class Solution {

    /**
     * 18 / 18 test cases passed.
     *  Status: Accepted
     *  Runtime: 6 ms
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder say = new StringBuilder("1");
        StringBuilder nextSay = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            char cur = '0';
            int cnt = 0;
            for (int j = 0; j < say.length(); j++) {
                if (say.charAt(j) != cur) {
                    if (cur != '0') {
                        nextSay.append((char) ('0' + cnt));
                        nextSay.append(cur);
                    }
                    cur = say.charAt(j);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            nextSay.append((char) ('0' + cnt));
            nextSay.append(cur);
            say = nextSay;
            nextSay = new StringBuilder();
        }
        return say.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(4));
    }

}
