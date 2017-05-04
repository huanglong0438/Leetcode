package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */

/**
 * 
 * @author DC
 * 多新鲜啊，其实没啥难的，就是比3Sum多了一维，加一层循环暴力搞定就可以了
 * 3Sum的时候就是按住一个不动，然后其余两个从前往后，从后往前移动（根据Sum和target的对比关系，注意先要排序）
 * 比较有趣的是去重这里用了一个Set，这里会执行List的对比函数equals，List的这个函数会分别对比里面的每一个元素，这里要注意
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<>();
    	Set<List<Integer>> nodouble = new HashSet<>();
        for(int i = 0; i < nums.length-3; i++){
        	for(int j = i + 1; j < nums.length-2; j++){
        		int start = j + 1;
        		int end = nums.length-1;
        		while(start < end){
	        		int sum = nums[i] + nums[j] + nums[start] + nums[end];
	        		if(sum == target){
	        			List<Integer> list = new ArrayList<>();
	        			list.add(nums[i]);
	        			list.add(nums[j]);
	        			list.add(nums[start]);
	        			list.add(nums[end]);
	        			//List的比较equal函数会对里面每一个元素进行比较
	        			if(!nodouble.contains(list)){
	        				result.add(list);
	        				nodouble.add(list);
	        			}
	        			start++;
	        			end--;
	        			continue;
	        		}
	        		else{
	        			if(sum < target){
	        				start++;
	        				continue;
	        			}
	        			if(sum > target){
	        				end--;
	        				continue;
	        			}
	        		}
        		}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		int s[] = {-3,-2,-1,0,0,1,2,3};
		Solution solution = new Solution();
		List<List<Integer>> result = solution.fourSum(s, 0);
		for(List list : result){
			System.out.println(list);
		}
	}
}
