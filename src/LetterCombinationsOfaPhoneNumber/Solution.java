package LetterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * ����˼·��
 * ˼·��ʵ�ǳ��ļ򵥣�����DFS��ʶ���˶��ῴ���������һ�����Ľṹ�������������������˳��ȥ������ͻ����εõ��������
 * Ȼ���Ҳ������г�ʶ���ˣ�û�뵽���ַ�����DFS�ǻ��ڵݹ�ģ��ݹ�����Ҫ���ڵģ����ҵݹ��ʱ����Ҫ�������Ϊ�������ݽ�ȥ��
 * ����DFS�ĺ����Ҿ�����index�������������ջ����ȣ�ͨ���������ѵ�ǰ�ķ�����Ҫ�߶�����ǲ����ߵ�ͷ��
 * ����һ��������forѭ������ӵݹ���ã���Ӧ����DFS�ı�׼��ʽ���Ժ���Ҫʹ��DFS��ʱ��Ӧ�ñ�������ģ��
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
     * dfs������еķ���
     * @param digits ��������֣�����"23"
     * @param index	��ʵ����ջ����ȣ�����ִ����2ִ��3��index����1��ջ����Ⱦ���2
     * @param middleStr �м��������������dfs�����ߵ�ͷ֮ǰ����ʱ����
     * @param map ��Ҫ�õ��Ĳ�����ȷ��������Ӧ��Ӣ����ĸ
     * @param result ��ʱ�����������ߵ�Ҷ�ӽڵ������ͻ�ŵ������Ϊ�������Ϊʹ�õݹ飬���԰ѽ��Ҳ�ŵ��˲�����
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
