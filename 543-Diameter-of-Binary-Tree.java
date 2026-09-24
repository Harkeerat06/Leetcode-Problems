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
    int ans= 1;
    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return 1;
        
        int leftD= helper(root.left);
        int rightD= helper(root.right);

        ans= Math.max(ans, leftD + rightD + 1);

        return Math.max(leftD, rightD) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ans-1;
    }
}