/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return root;
        
        if(root==q || root==p)
            return root;
        
        TreeNode leftT= lowestCommonAncestor(root.left, p, q);
        TreeNode rightT= lowestCommonAncestor(root.right, p, q);

        if(leftT!=null && rightT!=null)
            return root;
        
        if(leftT!=null)
            return leftT;
        
        return rightT;
    }
}