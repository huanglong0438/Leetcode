package GenerateParentheses;
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglongcheng01 on 2017/5/5.
 * 解题思路：
 * 主要还是一手DFS深度优先搜索，这一点我想到了，但是我不会用递归表示出来
 * DFS就是函数内执行双递归，两个递归，先递归第一个一直薅羊毛，薅秃了以后再搞第二个递归（两个递归好难理解啊~~）
 * BFS目测就是一手队列，先入队列，然后在循环里解决一个就把它的儿子插入队列
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, "", result);
        return result;
    }

    public static void dfs(int lefts, int rights, String s, List<String> result){
        //递归出口，找到了一个正确结果
        if (lefts == 0 && rights == 0){
            result.add(s);
        }
        if (lefts > 0) {
            dfs(lefts-1, rights, s+'(', result);
        }
        if (rights > 0 && lefts < rights) {
            dfs(lefts, rights-1, s+')', result);
        }
        //隐藏出口，就是各种不合法的结果，比如lefts>rights，左括号有富余
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(2);
        System.out.println(result);
    }
}
