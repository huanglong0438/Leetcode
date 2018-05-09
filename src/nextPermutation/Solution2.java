package nextPermutation;

/**
 * Created by donglongcheng01 on 2018/5/9.
 */
public class Solution2 {

    public void nextPermutation(int[] nums) {

        if (nums.length < 2) {
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int i1 = i;
                int i2 = i + 1;
                int[] res = new int[1];
                findLastGreater(nums[i1], nums, i2, nums.length - 1, res);
                int j = res[0];
                int temp = nums[j];
                nums[j] = nums[i1];
                nums[i1] = temp;

                for (int k = 0; k < (nums.length - i2) / 2; k++) {
                    int mid = nums[i2 + k];
                    nums[i2 + k] = nums[nums.length - 1 - k];
                    nums[nums.length - 1 - k] = mid;
                }

                return;
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int mid = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = mid;
        }
    }

    /**
     * [start, end]
     *
     * @param target
     * @param nums
     * @param start
     * @param end
     * @param res
     */
    private static void findLastGreater(int target, int[] nums, int start, int end, int[] res) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            res[0] = mid;
            findLastGreater(target, nums, mid + 1, end, res);
        } else {
            findLastGreater(target, nums, start, mid, res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
