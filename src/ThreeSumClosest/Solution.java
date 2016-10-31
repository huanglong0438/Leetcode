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
 * ����˼·:����һ��3Sum�Ľⷨһ����ֻ����ǰһ���ǱȽ�sum�Ƿ�Ϊ0�������Ǽ�¼��ǰsum��ֵ��������ӽ��˾͸�����
 * ������ǣ����������飬Ȼ��סһ������ʣ��������һ����ǰ���һ���Ӻ���ǰ�ߣ�
 * ���sum��ֵС��target�ˣ���ǰ������һ�������sum��ֵ���ˣ���������ǰ�����sumֵ����С�պõ���target����ֱ�ӷ��ؽ��sum
 * ��������ǰ�߻�������ߣ�������ּ�¼��closestDist��С�ˣ������̸��½�������������ѭ�������󷵻�result
 */

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
    	int closestDist = Integer.MAX_VALUE;
    	int result = 0;
    	Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
        	//����� -4 -4 1 2 �����������ôǰһ�μ���-4��ʱ����ʵ�Ѿ������˵ڶ�������-4��ʱ�����������Բ��˷�ʱ�䣬��������
        	if(i > 0 && nums[i] == nums[i-1]) continue;
        	
        	int j = i + 1;
        	int k = nums.length - 1;
        	while(j < k){
	        	int sum = nums[i] + nums[j] + nums[k];
	        	if(sum < target){
	        		//���sumС���ҵ�ǰ��λ�ø��ӽ�target�ˣ������
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
