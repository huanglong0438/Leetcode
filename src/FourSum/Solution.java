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
 * �����ʰ�����ʵûɶ�ѵģ����Ǳ�3Sum����һά����һ��ѭ�������㶨�Ϳ�����
 * 3Sum��ʱ����ǰ�סһ��������Ȼ������������ǰ���󣬴Ӻ���ǰ�ƶ�������Sum��target�ĶԱȹ�ϵ��ע����Ҫ����
 * �Ƚ���Ȥ����ȥ����������һ��Set�������ִ��List�ĶԱȺ���equals��List�����������ֱ�Ա������ÿһ��Ԫ�أ�����Ҫע��
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
	        			//List�ıȽ�equal�����������ÿһ��Ԫ�ؽ��бȽ�
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
