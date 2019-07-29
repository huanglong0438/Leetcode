package _1_two_sum.my;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过hash来解决two-sum问题
 *
 * @title Solution2
 * @Description
 * @Author donglongcheng01
 * @Date 2019-07-28
 **/
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[0];
        if(nums == null || nums.length < 2) {
            return result;
        }
        // 设置好Hash的初始化size，防止resize，可以提速更明显
        Map<Integer, Integer> numToIndex = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            if(numToIndex.get(target - nums[i]) != null) {
                result = new int[] {numToIndex.get(target - nums[i]), i};
                return result;
            } else {
                numToIndex.put(nums[i], i);
            }
        }
        return result;
    }

}
