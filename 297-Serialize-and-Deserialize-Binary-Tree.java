/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<String> list = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                list.add("null");
                continue;
            }

            list.add(String.valueOf(node.val));

            q.offer(node.left);
            q.offer(node.right);
        }

        // Remove trailing nulls
        while (list.get(list.size() - 1).equals("null")) {
            list.remove(list.size() - 1);
        }

        return String.join(",", list);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if (data.equals(""))
            return null;

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();

            // left child
            if (!arr[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.left);
            }
            i++;

            // right child
            if (i < arr.length && !arr[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));