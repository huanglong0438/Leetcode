package RomanToInteger;
/**
 * 
 * @author DC

	Given a roman numeral, convert it to an integer.
	
	Input is guaranteed to be within the range from 1 to 3999.
	
 *
 */

/*
	���IntegerToRoman
	�����ʵ�ֻ��ǡ���ǰ��������ԭ�ȵ��뷨�ǰ�5,10,50,100...��������һ���������ߣ
	�������뻹��naive���㷨�ı��ʾ����ҵ�����Ȼ������д�Ĵ������࣬��Щ�������һ����ͬ��
	�Ǿ���4��IVǰһ���Ⱥ�һ��ҪС��6��VIǰһ���Ⱥ�һ��Ҫ��
	ֻҪ����ǰһ���Ⱥ�һ��ҪС���������˵��Ҫ���м����������Ǽӷ�
	eg.XXXIV = 34
 */

public class Solution {
	
    public int romanToInt(String s) {
    	int result = 0;
        for(int i = 0; i < s.length(); i++){
        	int cur = toNumber(s.charAt(i));
        	//���û��ͷ���Һ�һ����ǰһ����˵��Ҫ������
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
