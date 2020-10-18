/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return diameter;
    }
    
    private int calculateDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);
        
        diameter = Math.max(diameter, rightDepth + leftDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}