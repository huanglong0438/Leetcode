package CombinationSum;
/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglongcheng01 on 2017/5/6.
 * So easy! 标准的DFS，只需要注意一下2，3，6，7，3的时候要从3以及3以后判断（去重）
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, list, sum, result);
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
        for (int i = index; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            temp.add(candidates[i]);
            dfs(candidates, target, i, temp, sum+candidates[i], result);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(candidates, 7);
        for (List<Integer> list : result
              ) {
            System.out.println(list);
        }
    }
}
