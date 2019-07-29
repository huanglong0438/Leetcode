package _1_two_sum.my;

/**
 * two-sum暴力解法
 *
 * @title ViolentSolution
 * @Description
 * @Author donglongcheng01
 * @Date 2019-07-28
 **/
public class ViolentSolution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[0];
        if(nums == null || nums.length < 2) {
            return result;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


}
