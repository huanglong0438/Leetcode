package flattenBinaryTreetoLinkedList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void flatten(TreeNode root) {
        TreeNode t = root;
        TreeNode p = root;
        TreeNode temp;
        //t from root
        while(t != null){
            while(t.left != null){
                temp = t.left;  //temp
                //push
                if(t.right != null) p.left = t.right;
                //put on the tree
                p.right = temp;
                p = p.right;
                //next
                t = temp;
            }
            //now t.left is null, so only may have right,so push t.right(don't forget parent)
            if(t.right != null) {
                p.left = t.right;
                t.right = null;
            }
            //pop()
            TreeNode f = null;
            TreeNode s = null;
            t = root;
            while(t != null){
                //if t has left, update f,s
                if(t.left != null){
                    s = t.left;
                    f = t;
                }
                t = t.right;
            }
            //if stack not empty,put s on the tree
            if(s != null){
                p.right = s;
                p = p.right;
                f.left = null;
            }
            //if s not update, stack is empty and t = s = null!
            t = s;
        }
    }
    
    public static void main(String argv[]){
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);
    	flatten(root);
    }
    
}
