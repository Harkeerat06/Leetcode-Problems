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
    public boolean checkNode(TreeNode p, TreeNode q)
    {
        if(p==null && q==null)
            return true;
        
        if(p==null || q==null || p.val!=q.val)
            return false;
        
        boolean leftT= checkNode(p.left, q.left);
        boolean rightT= checkNode(p.right, q.right);
    
        return leftT && rightT;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        
        if(checkNode(root, subRoot))
            return true;
        
        boolean leftT= isSubtree(root.left, subRoot);
        if(leftT)
            return true;

        boolean rightT= isSubtree(root.right, subRoot);
        return rightT;
    }
}