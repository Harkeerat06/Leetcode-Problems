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
    int visited=0, ans=-1;
    public void helper(TreeNode root, int k)
    {
        if(root==null || visited==k)
            return;

        helper(root.left, k);
        visited++;
        if(visited==k)
        {
            ans= root.val;
            return;
        }
        helper(root.right, k);
    }
    
    public int kthSmallest(TreeNode root, int k) {  
        helper(root, k);
        return ans;
    }
}