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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        int lvl=-1;

        while(!q.isEmpty())
        {
            int size= q.size();
            lvl++;
            int prev= lvl%2==0 ? -1 : Integer.MAX_VALUE;

            for(int i=0; i<size; i++)
            {
                TreeNode node= q.poll();

                // even level
                if(lvl%2==0)
                {
                    if(node.val%2==0 || node.val<=prev)
                        return false;
                }
                // odd level
                else 
                {
                    if(node.val%2==1 || node.val>=prev)
                        return false;
                }
                prev= node.val;

                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
        }
        return true;
    }
}