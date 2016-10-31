package IntegerToRoman;

/**
 * 
	Given an integer, convert it to a roman numeral.

	Input is guaranteed to be within the range from 1 to 3999.
	
 * @author DC
 *
 */

/*
 * �ܸо�������������������
 * I��1��V��5��X��10��L��50��C��100��D��500��M��1000
 * 1234 MCCXXXIV
 * 
 * ��������Լ����Ļ��϶����ñ������ˣ�[1,4),4,(4,9),9 �� ��ʮ��ǧλ������ϣ�һ���if..else..�����Ǵ�������
 * ���������ҵ��˺ܶ��˵ķ����������϶��ǰ��������ַŵ�һ���������棬�Ͱ��������ֶ������
 * ��������ķ�������������һ�����Ӹߵ��ͣ�һ��һ����������Ҳ�����������ֵ�һ�ֹ��ɰɣ���Ȼ����5��4����ĺܵ���
 * ����������ķ����м򵥴ֱ��Ľ���ˣ���tm����4��IV����IIII����ֱ���������ͺ��ˣ���
 * �ܽ᣺���ִӸߵ����������ķ���������ת���зǳ��򵥴ֱ�������ѧϰһ����
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
