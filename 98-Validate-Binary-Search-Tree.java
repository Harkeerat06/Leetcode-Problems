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
    public boolean helper(TreeNode root, long leftParentUpper, long rightParentLower)
    {
        if(root==null)
            return true;
        
        if(root.val >= leftParentUpper || root.val <= rightParentLower)
            return false;
        
        boolean leftTree= helper(root.left, root.val, rightParentLower);
        boolean rightTree= helper(root.right, leftParentUpper, root.val);

        return leftTree && rightTree;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MAX_VALUE+1L, Integer.MIN_VALUE-1L);
    }
}