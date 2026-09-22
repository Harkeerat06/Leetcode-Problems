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
    public int helper(TreeNode root, int maxTillNow, int minTillNow)
    {
        if(root==null)
            return 0;
        
        int maxNext= Math.max(root.val, maxTillNow);
        int minNext= Math.min(root.val, minTillNow);

        int maxLD= helper(root.left, maxNext, minNext);
        int maxRD= helper(root.right, maxNext, minNext);

        int maxDiff= Math.max(Math.abs(maxTillNow - root.val), Math.abs(root.val - minTillNow));
        return Math.max(maxDiff, Math.max(maxRD, maxLD));
    }

    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
}