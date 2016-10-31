package IntegerToRoman;

/**
 * 
	Given an integer, convert it to a roman numeral.

	Input is guaranteed to be within the range from 1 to 3999.
	
 * @author DC
 *
 */

/*
 * 总感觉这题我做过啊。。。
 * I是1，V是5，X是10，L是50，C是100，D是500，M是1000
 * 1234 MCCXXXIV
 * 
 * 如果是我自己做的话肯定就用笨方法了，[1,4),4,(4,9),9 和 个十百千位进行组合，一大堆if..else..（真是蠢。。）
 * 但是网上找到了很多人的方法，大致上都是把罗马数字放到一个数组里面，和阿拉伯数字对齐放置
 * 比如下面的方法，像消消乐一样，从高到低，一层一层消掉，这也算是罗马数字的一种规律吧，虽然它的5和4处理的很蛋疼
 * 但是在下面的方法中简单粗暴的解决了（我tm管你4是IV还是IIII，我直接往下消就好了！）
 * 总结：这种从高到低往下消的方法在数字转换中非常简单粗暴，可以学习一个。
 */


public class Solution {

    public String intToRoman(int num) {
    	//eg.1234
    	int values[] = 		{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	String numerals[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    	StringBuilder result = new StringBuilder();
    	for(int i = 0; i < values.length; i++){
    		while(num >= values[i]){
    			num -= values[i];
    			result.append(numerals[i]);
    		}
    	}
    	return result.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Integer to Roman.");
		String result = new Solution().intToRoman(1234);
		System.out.println(result);
	}

}
