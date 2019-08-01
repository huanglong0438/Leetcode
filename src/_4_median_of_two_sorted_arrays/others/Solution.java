package _4_median_of_two_sorted_arrays.others;

/**
 * https://blog.csdn.net/yutianzuijin/article/details/11499917
 *
 * https://www.youtube.com/watch?v=KB9IcSCDQ9k
 *
 * @Author: donglongcheng
 * @Description:
 * @Date: Create in 23:58 2019/7/30
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            // always ensure m <= n
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (m + n + 1) / 2;
        int iMin = 0;
        int iMax = m;
        int i,j;
        while(iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = k - i;
            // 只关注i，j是联动的，i需要小于iMax因为i最大有可能等于iMax导致越界，需要阻止这种情况
            if(i < iMax && nums1[i] < nums2[j-1]) {
                // i is too small
                iMin = i + 1;
            } else if(i > iMin && nums1[i - 1] > nums2[j]) {
                // i需要大于iMin，是因为这里要读nums1[i-1]，有可能越界，注意iMin和iMax是[iMin,iMax)
                // i is too big
                iMax = i - 1;
            } else {
                // i is perfect
                int maxLeft = 0;
                if(i == 0) {
                    maxLeft = nums2[j - 1];
                } else if(j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if((m + n) % 2 == 1){
                    return maxLeft;
                }
                int minRight = 0;
                if(i == m){
                    minRight = nums2[j];
                } else if(j == n){
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}
