package _33_SearchInRotatedSortedArray;

/**
 * Created by donglongcheng01 on 2018/5/11.
 */
public class Solution {

    /**
     * 196 / 196 test cases passed.
     *  Status: Accepted
     *  Runtime: 15 ms
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] == target) {
            return start;
        }

        if (nums[start] < nums[mid]) {
            if (target < nums[start] || target > nums[mid]) {
                return find(nums, mid + 1, end, target);
            } else {
                return find(nums, start, mid - 1, target);
            }
        } else if (nums[start] > nums[mid]) {
            if (target > nums[start] || target < nums[mid]) {
                return find(nums, start, mid - 1, target);
            } else {
                return find(nums, mid + 1, end, target);
            }
        } else {
            return find(nums, mid + 1, end, target);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[] { 4,5,6,7,0,1,2 }, 3));
    }
}
