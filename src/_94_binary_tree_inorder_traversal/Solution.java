package _94_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 非递归中序遍历的套路
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 *
 * @title Solution
 * @Description
 * @Author donglongcheng01
 * @Date 2020-05-09
 **/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Deque<Object> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Object object = stack.pop();
            if(object instanceof TreeNode) {
                pushWithOrder(stack, object);
            } else {
                result.add((Integer) object);
            }
        }

        return result;

    }

    private void pushWithOrder(Deque<Object> stack, Object object) {
        TreeNode node = (TreeNode) object;
        if(node.right != null) {
            stack.push(node.right);
        }
        stack.push(node.val);
        if(node.left != null) {
            stack.push(node.left);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}