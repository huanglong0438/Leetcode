package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by donglongcheng01 on 2017/5/6.
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, -1, list, sum, result);
        return result;
    }

    public void dfs(int[] candidates, int target, int index, List<Integer> list, int sum, List<List<Integer>> result) {
        if (sum == target) {
            result.add(list);
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index+1; i < candidates.length; i++) {
            // 如果i和【他之前的】【本次循环的】数字相同，则跳过
            if (i - index > 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            temp.add(candidates[i]);
            dfs(candidates, target, i, temp, sum+candidates[i], result);
        }
    }

    public static void main(String[] args) {
        int candidates[] = {10,1,2,7,6,1,5};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum2(candidates, 8);
        for (List<Integer> list: result
             ) {
            System.out.println(list);
        }
    }
}
