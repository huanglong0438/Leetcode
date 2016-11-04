package LetterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * 解题思路：
 * 思路其实非常的简单，稍有DFS常识的人都会看出，这就是一个树的结构，按照深度优先搜索的顺序去搜索完就会依次得到各个结果
 * 然而我不是稍有常识的人，没想到这种方法，DFS是基于递归的，递归是需要出口的，而且递归的时候需要将结果作为参数传递进去，
 * 以下DFS的核心我觉得是index这个参数，它是栈的深度，通过它来提醒当前的方法你要走多深，你是不是走到头了
 * 而另一个核心是for循环里面加递归调用，这应该是DFS的标准形式，以后需要使用DFS的时候应该背下这种模板
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<>();
        String map[] = new String[10];
        map[0] = "";
        map[1] = "";
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        char[] middleStr = new char[digits.length()];
        dfsGetStr(digits, 0, middleStr, map, result);
        return result;
    }
    
    /**
     * dfs获得排列的方法
     * @param digits 输入的数字，例如"23"
     * @param index	其实就是栈的深度，例如执行完2执行3，index就是1，栈的深度就是2
     * @param middleStr 中间变量，用来保存dfs遍历走到头之前的临时变量
     * @param map 需要用到的参数，确定按键对应的英文字母
     * @param result 临时变量从树根走到叶子节点走完后就会放到这里，作为结果，因为使用递归，所以把结果也放到了参数中
     */
    private void dfsGetStr(String digits, int index, char[] middleStr, String[] map, List<String> result){
    	if(digits.length() == 0){
    		return;
    	}
    	if(index == digits.length()){
    		result.add(new String(middleStr));
    		return;
    	}
    	char curDigit = digits.charAt(index);
    	for(int i = 0; i < map[curDigit - '0'].length(); i++){
    		middleStr[index] = map[curDigit - '0'].charAt(i);
    		dfsGetStr(digits, index+1, middleStr, map, result);
    	}
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> result = solution.letterCombinations("23");
		System.out.println(result);
	}
}
