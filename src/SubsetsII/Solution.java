package SubsetsII;
/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

import java.util.*;

/**
 * Created by donglongcheng01 on 2017/5/6.
 * 解题思路：
 * 同SubSets，只不过这里有了重复项，所以需要去重，
 * 去重只需要搞个Set存就可以了，注意有个坑，要先对数组排序，否则Set进行equals函数比较的时候无法看出1，2，2和2，2，1
 *
 * 另一个方法也是先排序，然后不用Set，在二叉树遍历的时候就判断nums[i] == nums[i+1]来判断是不是要递归下一步
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, 0, list, set);
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }

    public static void dfs(int[] nums, int i, List<Integer> list, Set<List<Integer>> result) {
        if (i == nums.length) {
            result.add(list);
            return;
        }
        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        temp.add(nums[i]);
        dfs(nums, i+1, temp, result);
        List<Integer> temp2 = new ArrayList<>();
        temp2.addAll(list);
        dfs(nums, i+1, temp2, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 4, 4, 1, 4};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
