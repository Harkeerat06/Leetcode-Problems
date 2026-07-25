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
    public boolean check(TreeNode root, long leftVal, long rightVal)
    {
        if(root==null)
            return true;

        if(leftVal>=root.val || rightVal<=root.val)
            return false;
        
        boolean leftT= check(root.left, leftVal, root.val);
        boolean rightT= check(root.right, root.val, rightVal);

        return leftT && rightT;
    }
    
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}