package RegularExpressionMatching;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author DC
 *
 *
	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") �� false
	isMatch("aa","aa") �� true
	isMatch("aaa","aa") �� false
	isMatch("aa", "a*") �� true
	isMatch("aa", ".*") �� true
	isMatch("ab", ".*") �� true
	isMatch("aab", "c*a*b") �� true
 */

/*
 *  ��������ɧ�ˣ�������кü�����
 *  ����������һ���ǹ��ؾص�a*�����ǻ����a*a���������ܼ򻯵ĸ�ʽ
 *  ���������лع��Ļ��ƣ���Ϊ���£�
	Input: "aaa"
		   "a*a"
	Output: false
	Expected: true 
	
	�����˳��ƥ�������ᷢ��a*���Ѿ���aaaƴ���ˣ�ʣ��һ��aƥ��ʧ�ܣ�GG
	��������*Ҫ����ǰ��������ǰ���Ǻö��㷨�⾭���õ��ļ���
	
	��Σ�aƥ�䵽a*�����ǰ����Ȼ��aaa�ͻ�ͺ���һ��aƥ�䣬Ҳ��GG����ʱ����ʵû�д�
	���Ի���Ҫ���ع����Ļ��ƣ�
	��aaaƥ��aʧ�ܺ���ʵ�����������ʧ���ˣ���Ҫ�ع�����*ƥ���ѭ�����Ȼ����һ��ѭ�����aa
	�ٱ��a���ٺ�*����Ĳ���ƥ���ok��
	
	�ܽ᣺�����ص㣬һ���ǡ���ǰ������һ���ǻع�����ǰ��ͨ��p[i+1]������ع�ͨ����¼�ع�ǰ��ֵ���ߵݹ�����
	����ǵݹ飬��ⷽ�㣬��Ȼ�����������ܻ��Щ��GTMD���ܣ��ݹ飡�Ҳ��ܣ��͵ݹ��ˣ�
 */



public class Solution {

    public boolean isMatch(String s, String p) {
    	return isMatch(s, p, 0, 0);
    }
	
    public boolean isMatch(String s, String p, int i, int j){
    	//�ݹ�ĳ���,Խ���������ӵ�����
    	if(j >= p.length())
    		return i >= s.length();
    	//ֻҪp����һλ����*���������������p����һλ����*������j+1�ɴ�Խ���ˣ�
    	if(j+1 >= p.length() || p.charAt(j+1) != '*'){
    		if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
    			return isMatch(s, p, i+1, j+1);
    		else
    			return false;
    	}
    	//p����һλ��*�����
    	else{
    		while(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
    			if(isMatch(s, p, i, j+2))
    				return true;
    			i++;
    		}
    		return isMatch(s, p, i, j+2);
    	}
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		boolean b = solution.isMatch("ab", ".*c");
		System.out.println(b);
	}
}


