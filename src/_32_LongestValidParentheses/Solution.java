package _32_LongestValidParentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by donglongcheng01 on 2018/5/10.
 */
public class Solution {

    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int cnt = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    cnt = stack.isEmpty() ? max(cnt, i - start + 1) : max(cnt, i - stack.peek());
                }
            }
        }
        return cnt;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("()(()"));
    }

}
