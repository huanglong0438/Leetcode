package _42_Trapping_Rain_Water;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by donglongcheng01 on 2018/5/17.
 */
public class Solution {

    /**
     * O(n^2)
     *
     * 315 / 315 test cases passed.
     *  Status: Accepted
     *  Runtime: 34 ms
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                // 下坡，就入栈
                stack.push(i);
            } else {
                // 发现上坡
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int pre = stack.pop();
                    if (!stack.isEmpty()) {
                        res += (min(height[stack.peek()], height[i]) - height[pre]) * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }


    /**
     *  315 / 315 test cases passed.
     *  Status: Accepted
     *  Runtime: 21 ms
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        int res = 0;
        int[] container = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            container[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            container[i] = Math.min(max, container[i]);
            max = Math.max(max, height[i]);
            res += container[i] - height[i] > 0 ? container[i] - height[i] : 0;
        }
        return res;
    }


    private int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap1(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
