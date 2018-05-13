package _35_Search_Insert_Position;

/**
 * Created by donglongcheng01 on 2018/5/13.
 */
public class Solution {

    /**
     * 62 / 62 test cases passed.
     *  Status: Accepted
     *  Runtime: 5 ms
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        return findPosition(nums, 0, nums.length - 1, target, -1);
    }

    public int findPosition(int[] nums, int start, int end, int target, int possible) {

        if (start > end) {
            return possible;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return findPosition(nums, start, mid - 1, target, mid);
        } else {
            return findPosition(nums, mid + 1, end, target, mid + 1);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{ 1,3,5,6 }, 0));
    }
}
