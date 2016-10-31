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
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true
 */

/*
 *  出题的这个骚人，这个题有好几个坑
 *  首先是它不一定是规规矩矩的a*，而是会出现a*a这种明显能简化的格式
 *  其次是最好有回滚的机制，因为如下：
	Input: "aaa"
		   "a*a"
	Output: false
	Expected: true 
	
	如果你顺着匹配下来会发现a*就已经跟aaa拼完了，剩下一个a匹配失败，GG
	所以遇到*要“向前看”，向前看是好多算法题经常用到的技巧
	
	其次，a匹配到a*后会向前看，然后aaa就会和后面一个a匹配，也会GG，这时候其实没有错，
	所以还需要“回滚”的机制，
	即aaa匹配a失败后，其实它并不是真的失败了，需要回滚到和*匹配的循环那里，然后下一个循环变成aa
	再变成a，再和*后面的部分匹配就ok了
	
	总结：两个重点，一个是“向前看”，一个是回滚。向前看通过p[i+1]解决，回滚通过记录回滚前的值或者递归解决，
	最好是递归，理解方便，虽然迭代好像性能会好些，GTMD性能！递归！我不管，就递归了！
 */



public class Solution {

    public boolean isMatch(String s, String p) {
    	return isMatch(s, p, 0, 0);
    }
	
    public boolean isMatch(String s, String p, int i, int j){
    	//递归的出口,越界的情况都扔到这里
    	if(j >= p.length())
    		return i >= s.length();
    	//只要p的下一位不是*的所有情况（或者p的下一位不是*，或者j+1干脆越界了）
    	if(j+1 >= p.length() || p.charAt(j+1) != '*'){
    		if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
    			return isMatch(s, p, i+1, j+1);
    		else
    			return false;
    	}
    	//p的下一位是*的情况
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


