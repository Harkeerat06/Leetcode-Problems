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
    List<int[]> nodes= new ArrayList<>();

    public void inOrder(TreeNode root, int col, int row)
    {
        if(root==null)
            return;

        nodes.add(new int[]{col, row, root.val});
        inOrder(root.left, col-1, row+1);
        inOrder(root.right, col+1, row+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        inOrder(root, 0, 0);
        Collections.sort(nodes, (a,b) -> {
            if(a[0]==b[0] && a[1]==b[1])
                return Integer.compare(a[2], b[2]);
            else if(a[0]==b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        List<List<Integer>> ans= new ArrayList<>();
        int n= nodes.size(), i=0;

        while(i<n)
        {
            int currCol= nodes.get(i)[0];
            List<Integer> list= new ArrayList<>();

            while(i<n && nodes.get(i)[0] == currCol)
            {
                list.add(nodes.get(i)[2]);
                i++;
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}