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
    int idx=0;
    public TreeNode helper(int preorder[], int start, int end, HashMap<Integer, Integer> inOrderMap)
    {
        if(start>end)
            return null;

        int rootVal= preorder[idx++];
        TreeNode root= new TreeNode(rootVal);

        int idxInorder= inOrderMap.get(rootVal);

        root.left= helper(preorder, start, idxInorder-1, inOrderMap);
        root.right= helper(preorder, idxInorder+1, end, inOrderMap);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderIdx= new HashMap<>();
        int n= inorder.length;
        
        for(int i=0; i<n; i++)
        {
            inOrderIdx.put(inorder[i], i);
        }

        return helper(preorder, 0, n-1, inOrderIdx);
    }
}