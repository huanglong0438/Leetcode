package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author DC
 *
 *Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 *Find all unique triplets in the array which gives the sum of zero.
 *
 */
/*
 	求3Sum是一系列的问题，K Sum的问题。
 	2Sum就是最基本的情况，先排序，然后从头-> 从尾<-对着走，找到和为0的一对（注意走的时候和上一位比较一下，可以防止重复的情况发生）
 	3Sum就需要多一个控制，按住一个位置不动，然后让后面的部分进行2Sum（注意这里是让{后面}的部分进行2Sum，而不带上前面，可以防止重复）
 */

public class Solution {
	
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        sort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
        	int begin = i + 1;
        	int end = nums.length - 1;
        	if(i > 0 && nums[i] == nums[i-1])
        		continue;
        	while(begin < end){        		
        		if(begin > i + 1 && nums[begin] == nums[begin - 1]){
        			begin++;
        			continue;
        		}
        		if(end < nums.length - 1 && nums[end] == nums[end + 1]){
        			end--;
        			continue;
        		}
        		int sum = nums[i] + nums[begin] + nums[end];
        		if(sum < 0){
        			begin++;
        		}
        		else if(sum > 0){
        			end--;
        		}
        		else{
        			List<Integer> triple = new ArrayList<>();
        			triple.add(nums[i]);
        			triple.add(nums[begin]);
        			triple.add(nums[end]);
        			result.add(triple);
        			begin++;
        		}
        	}
        }
        return result;
    }

    private void sort(int[] nums, int p, int r){
    	int q;
    	if(p<r){
    		q = partition(nums, p, r);
    		sort(nums, p, q-1);
    		sort(nums, q+1, r);
    	}
    }
    
    private int partition(int[] nums, int p, int r){
    	int x = nums[r];
    	int i = p - 1;
    	int j;
    	for(j = p; j <= r - 1; j++){
    		if(nums[j] < x){
    			i++;
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
    
	public static void main(String[] args) {
		//sorted -4 -1 -1 0 1 2
		int nums[] = { -1, 0, 1, 2, -1, -4 };
		Solution solution = new Solution();
		System.out.println(solution.threeSum(nums));
	}

}
