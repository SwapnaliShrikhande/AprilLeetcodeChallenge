/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int nodeSum;
    
    public int inOrder(TreeNode node) {
        if (node == null)
            return 0;
        
        //visit root
        int leftMax = Math.max(inOrder(node.left), 0);
        int rightMax = Math.max(inOrder(node.right), 0);
        nodeSum = Math.max(nodeSum, leftMax + rightMax + node.val);
        
        return Math.max(leftMax, rightMax) + node.val;
    }
    
    public int maxPathSum(TreeNode root) {
        nodeSum = -99;
        inOrder(root);
        return nodeSum;
    }
}