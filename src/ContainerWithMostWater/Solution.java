package ContainerWithMostWater;

/**
 *
 * @author DC
 *
 *	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
 *
 */

/*
 *		|		 |
 * 像是	||		|| 这种情况，外面的高，中间的低，外面的是一定会比里面的容量大的，
 *
 * 把思路逆转一下，如果以外面的为基准[向内侧收缩]，那像上面那样中间低的情况就可以直接PASS了，可以PASS掉好多，节省时间
 *
 * 总结：像这种问题就是个奇淫巧技，你想到了就直接做出来了，首先要想的是如何将比较的次数变小，跳过那些没有意义的
 * 		在规律上大小是规定好的情况。
 */

public class Solution {

	public int maxArea(int[] height) {
		int res = 0;
		int l = 0, r = height.length - 1;
		while(l < r){
			res = max(res, min(height[l], height[r]) * (r-l));
			if(height[l] < height[r]){
				int k = l;
				//这一步就是在pass掉那些比都不用比肯定小的情况
				while(k < r && height[k] <= height[l]){
					k++;
				}
				l = k;
			}
			else{
				int k = r;
				while(k > l && height[k] <= height[r]){
					k--;
				}
				r = k;
			}
		}
		return res;
	}

	public static int max(int a, int b){
		return a > b ? a : b;
	}

	public static int min(int a, int b){
		return a < b ? a : b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Container With Most Water.");
		int height[] = {0,1};
		int result = new Solution().maxArea(height);
		System.out.println(result);
	}

}
