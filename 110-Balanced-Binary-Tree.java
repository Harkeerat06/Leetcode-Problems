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
    boolean isBalanced= true;
    public int helper(TreeNode root)
    {
        if(root==null || !isBalanced)
            return 0;
        
        int leftT= helper(root.left);
        int rightT= helper(root.right);

        if(Math.abs(leftT-rightT) > 1)
            isBalanced= false;
        
        return Math.max(leftT, rightT) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isBalanced;
    }
}