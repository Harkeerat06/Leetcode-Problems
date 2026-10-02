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

 /* Answer can be any of maxSumPath on left subtree or right subtree. Or it can be either root.val, maxSumFromLeft+root.val, maxSumFromRight+root.val */
class Solution {
    public int[] helper(TreeNode root)
    {
        if(root==null)
            return new int[]{0, Integer.MIN_VALUE};

        // [largestSum, maxPathSum]
        int arrLeft[]= helper(root.left);
        int arrRight[]= helper(root.right);

        int rootVal= root.val;

        int currPathSum= Math.max(arrLeft[0]+arrRight[0]+rootVal, Math.max(rootVal, Math.max(arrLeft[0],arrRight[0])+rootVal));
        int maxSumPath= Math.max(currPathSum, Math.max(arrLeft[1], arrRight[1]));

        int maxSum= Math.max(Math.max(arrLeft[0],arrRight[0])+rootVal, rootVal);

        return new int[]{maxSum, maxSumPath};
    }

    public int maxPathSum(TreeNode root) {
        return helper(root)[1];
    }
}