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
 * ����	||		|| �������������ĸߣ��м�ĵͣ��������һ����������������ģ�
 * 
 * ��˼·��תһ�£�����������Ϊ��׼[���ڲ�����]���������������м�͵�����Ϳ���ֱ��PASS�ˣ�����PASS���ö࣬��ʡʱ��
 * 
 * �ܽ᣺������������Ǹ������ɼ������뵽�˾�ֱ���������ˣ�����Ҫ�������ν��ȽϵĴ�����С��������Щû�������
 * 		�ڹ����ϴ�С�ǹ涨�õ������
 */

public class Solution {

    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
        	res = max(res, min(height[l], height[r]) * (r-l));
        	if(height[l] < height[r]){
        		int k = l;
        		//��һ��������pass����Щ�ȶ����ñȿ϶�С�����
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
