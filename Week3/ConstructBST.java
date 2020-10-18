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
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return createBST(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode createBST(int[] preorder, int maxVal) {
        if (i == preorder.length || preorder[i] > maxVal)
            return null;
        
        TreeNode bst = new TreeNode(preorder[i++]);
        bst.left = createBST(preorder, bst.val);
        bst.right = createBST(preorder, maxVal);
        
        return bst;
    }
}