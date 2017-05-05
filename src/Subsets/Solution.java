package Subsets;
/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglongcheng01 on 2017/5/5.
 * 又是一道DFS的练手题，通过这道题找到DFS的手感
 * 思路：
 * 首先先画出树状图，有1，无1，有2，无2，有3，无3
 * 然后根据树状图来写递归
 * 注意：
 * 经过两次的DFS题我发现了DFS递归函数的固定套路，
 * 若干个参数表示DFS中要分歧的条件，一个参数表示DFS中一次结果的中间值，一个参数表示最终结果的集合
 * 一次结果的中间值这个注意一定要值传递，像本题的List就是指针传递，就很麻烦，所以需要每次执行递归前新创建一个List
 * 两个递归的分歧很好写，重要的是出口，出口这里一般会把中间值给写入到最终结果的集合，
 * 因此上面才需要值传递，因为中间值写完之后就没用了，后面递归栈弹出就不要了，如果传指针的话会导致还在往这里写
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //对于nums里面的每一个元素，有或者没有，进行DFS
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, list, result);
        return result;
    }

    public static void dfs(int[] nums, int i, List<Integer> list, List<List<Integer>> result) {
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
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
