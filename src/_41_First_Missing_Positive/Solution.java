package _41_First_Missing_Positive;

/**
 * Created by donglongcheng01 on 2018/5/16.
 */
public class Solution {

    /**
     * 157 / 157 test cases passed.
     *  Status: Accepted
     *  Runtime: 14 ms
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                // swap nums[i] with nums[nums[i] - 1]
                int cur = nums[i] - 1;
                if (cur >= 0 && cur < nums.length && nums[cur] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[cur];
                    nums[cur] = temp;
                    i--;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
