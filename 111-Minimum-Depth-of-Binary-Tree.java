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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return 1;
        
        int leftT= minDepth(root.left);
        int rightT= minDepth(root.right);

        if(leftT==0)  return rightT+1;
        if(rightT==0) return leftT+1;

        return Math.min(leftT, rightT) + 1;
    }
}