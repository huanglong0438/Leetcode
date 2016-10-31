package ThreeSumClosest;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
   The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/*
 * 解题思路:和上一个3Sum的解法一样，只不过前一个是比较sum是否为0，这里是记录当前sum的值，如果更接近了就更新它
 * 具体就是，先排序数组，然后按住一个数，剩下两个数一个从前向后，一个从后向前走，
 * 如果sum的值小于target了，则前面的向后一步，如果sum的值大了，则后面的向前，如果sum值不大不小刚好等于target，则直接返回结果sum
 * 不论是向前走还是向后走，如果发现记录的closestDist更小了，就立刻更新结果，最后在整个循环结束后返回result
 */

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
    	int closestDist = Integer.MAX_VALUE;
    	int result = 0;
    	Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
        	//如果是 -4 -4 1 2 这种情况，那么前一次计算-4的时候其实已经包含了第二次遇见-4的时候的情况，所以不浪费时间，果断跳过
        	if(i > 0 && nums[i] == nums[i-1]) continue;
        	
        	int j = i + 1;
        	int k = nums.length - 1;
        	while(j < k){
	        	int sum = nums[i] + nums[j] + nums[k];
	        	if(sum < target){
	        		//如果sum小，且当前的位置更接近target了，则更新
	        		if(target - sum < closestDist){
	        			closestDist = target - sum;
	        			result = sum;
	        		}
	        		j++;
	        	}
	        	else if(sum > target){
	        		if(sum - target < closestDist){
	        			closestDist = sum - target;
	        			result = sum;
	        		}
	        		k--;
	        	}
	        	else{
	        		return sum;
	        	}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-4, -1, 1, 2};
		int nums2[] = {0, 1, 2};
		Solution solution = new Solution();
		System.out.println(solution.threeSumClosest(nums2, 0));
	}

}
