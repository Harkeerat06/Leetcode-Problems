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
    int idx;

    public TreeNode builder(int postorder[], int start, int end, HashMap<Integer, Integer> map)
    {
        if(start>end)
            return null;
        
        int rootVal= postorder[idx--];
        TreeNode root= new TreeNode(rootVal);

        int inorderIdx= map.get(rootVal);
        root.right= builder(postorder, inorderIdx+1, end, map);
        root.left= builder(postorder, start, inorderIdx-1, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n= inorder.length;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<n; i++)
        {
            map.put(inorder[i], i);
        }

        idx= n-1;
        return builder(postorder, 0, n-1, map);
    }
}