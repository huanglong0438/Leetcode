package FourSum;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashSolution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Map<Integer,List<List<Integer>>> hash = new HashMap<>();
		//写入hash
		for(int i = 0; i < nums.length-1; i++){
			for(int j = i+1; j < nums.length; j++){
				if(hash.get(nums[i]+nums[j]) != null){
					List<Integer> pair = new ArrayList<>();
					pair.add(nums[i]);
					pair.add(nums[j]);
					hash.get(nums[i]+nums[j]).add(pair);
				}
				else{
					List<List<Integer>> list = new ArrayList<>();
					List<Integer> pair = new ArrayList<>();
					pair.add(nums[i]);
					pair.add(nums[j]);
					list.add(pair);
					hash.put(nums[i]+nums[j], list);
				}
			}
		}
		//排序
		Integer[] keys = new Integer[hash.keySet().size()];
		hash.keySet().toArray(keys);
		sort(keys,0,keys.length-1);
		int start = 0, end = keys.length-1;
		//2sum
		List<List<Integer>> result = new ArrayList<>();
		while(start < end){
			int sum = keys[start] + keys[end];
			if(sum == target){
				List<List<Integer>> four
						= combine(hash.get(keys[start]),hash.get(keys[end]));
				result.addAll(four);
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
		return result;
	}

	public static void sort(Integer nums[], int i, int j){
		if(i < j){
			int q = partition(nums, i, j);
			sort(nums, i, q -1);
			sort(nums, q+1, j);
		}
	}

	public static int partition(Integer nums[], int p, int r){
		int i = p - 1; //小区域的最后一个
		int x = nums[r]; //基准
		int j; //先驱
		for(j = p; j < r; j++){
			if(nums[j] < x){
				i++; //小区域扩张
				//小区域和先驱交换
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[i+1];
		nums[i+1] = nums[r];
		nums[r] = temp;
		return i+1;
	}

	public static List<List<Integer>> combine(List<List<Integer>> list1,List<List<Integer>> list2){
		List<List<Integer>> result = new ArrayList<>();
		for(List<Integer> pair1 : list1){
			for(List<Integer> pair2 : list2){
				List<Integer> four = new ArrayList<>();
				four.addAll(pair1);
				four.addAll(pair2);
				result.add(four);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int s[] = {1, 0, -1, 0, -2, 2};
		HashSolution solution = new HashSolution();
		List<List<Integer>> result = solution.fourSum(s, 0);
		for(List list : result){
			System.out.println(list);
		}
	}
}
