package nextPermutation;

/**
 * Created by donglongcheng01 on 2018/5/9.
 */
public class Solution {

    /**
     * 265 / 265 test cases passed.
     *  Status: Accepted
     *  Runtime: 21 ms
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        if (nums.length < 2) {
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            // 找到nums[i1] < nums[i2]的
            if (nums[i] < nums[i + 1]) {
                int i1 = i;
                int i2 = i + 1;
                // 从后面找到第一个比nums[i1]大的（刚好比nums[i1]大的）
                for (int j = nums.length - 1; j >= i2; j--) {
                    if (nums[j] > nums[i1]) {
                        // 交换，以达到i1的位置被换到尽量小的下一个
                        int temp = nums[j];
                        nums[j] = nums[i1];
                        nums[i1] = temp;

                        // i1后面的数必定是逆序，逆序是字典序最大的，因此翻转，换成顺序，顺序是字典序里最小的
                        for (int k = 0; k < (nums.length - i2) / 2; k++) {
                            int mid = nums[i2 + k];
                            nums[i2 + k] = nums[nums.length - 1 - k];
                            nums[nums.length - 1 - k] = mid;
                        }
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int mid = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = mid;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 7, 6, 2, 5, 4, 3, 1};
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
