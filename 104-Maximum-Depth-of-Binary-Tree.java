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
    int ans=0;
    public void helper(TreeNode root, int depth)
    {
        if(root==null)
            return;
        
        depth++;
        ans= Math.max(depth, ans);

        helper(root.left, depth);
        helper(root.right, depth);
    }

    public int maxDepth(TreeNode root) {
        helper(root, 0);
        return ans;
    }
}