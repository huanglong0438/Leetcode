package RomanToInteger;
/**
 * 
 * @author DC

	Given a roman numeral, convert it to an integer.
	
	Input is guaranteed to be within the range from 1 to 3999.
	
 *
 */

/*
	详见IntegerToRoman
	具体的实现还是“向前看”，我原先的想法是把5,10,50,100...这样的数一个个分情况撸
	现在想想还是naive，算法的本质就是找到规律然后让书写的代码更简洁，这些情况都有一个共同点
	那就是4是IV前一个比后一个要小，6是VI前一个比后一个要大
	只要遇到前一个比后一个要小的情况，就说明要进行减法，否则都是加法
	eg.XXXIV = 34
 */

public class Solution {
	
    public int romanToInt(String s) {
    	int result = 0;
        for(int i = 0; i < s.length(); i++){
        	int cur = toNumber(s.charAt(i));
        	//如果没到头，且后一个比前一个大，说明要做减法
        	if(i + 1 < s.length() && toNumber(s.charAt(i+1)) > cur){
        		result += toNumber(s.charAt(i+1)) - cur;
        		i++;
        	}
        	else{
        		result += cur;
        	}
        }
        return result;
    }
    
    private int toNumber(char ch) {  
        switch (ch) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }  
        return 0;  
    }  
    
	public static void main(String[] args) {
		String roman = "MCMLXXVI"; // 1976
		Solution solution = new Solution();
		System.out.println(roman + " is " +solution.romanToInt(roman));
	}

}
