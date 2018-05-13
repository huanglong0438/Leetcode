package _34_Search_for_a_Range;

/**
 * Created by donglongcheng01 on 2018/5/12.
 */
public class Solution {


    /**
     * 88 / 88 test cases passed.
     *  Status: Accepted
     *  Runtime: 8 ms
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, 0, nums.length - 1, target);
        int right = findRight(nums, left, nums.length - 1, target);
        return new int[]{left, right};
    }

    private int findLeft(int[] nums, int start, int end, int target) {

        if (start > end) {
            return  -1;
        }

        int result;

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            result = mid;
            int res = findLeft(nums, start, mid - 1, target);
            if (res != -1) {
                result = res;
            }
            return result;
        } else if (nums[mid] > target) {
            return findLeft(nums, start, mid - 1, target);
        } else {
            return findLeft(nums, mid + 1, end, target);
        }

    }

    private int findRight(int[] nums, int start, int end, int target) {

        if (start < end) {
            return  -1;
        }

        int result;

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            result = mid;
            int res = findRight(nums, mid + 1, end, target);
            if (res != -1) {
                result = res;
            }
            return result;
        } else if (nums[mid] > target) {
            return findRight(nums, start, mid - 1, target);
        } else {
            return findRight(nums, mid + 1, end, target);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] res = solution.searchRange(new int[]{5, 7, 8, 8, 8, 10}, 8);
        int[] res = solution.searchRange(new int[]{5, 7, 8, 8, 8, 10}, 6);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }

}
