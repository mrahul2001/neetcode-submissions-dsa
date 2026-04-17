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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);

        return String.join(",", res);
    }

    private void dfsSerialize(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("null");
            return;
        }

        res.add(String.valueOf(root.val));
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        return dfsDeserialize(vals);
    }

    int item = 0;

    private TreeNode dfsDeserialize(String[] vals) {
        if (vals[item].equals("null")){
            item++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[item]));
        item++;

        node.left = dfsDeserialize(vals);
        node.right = dfsDeserialize(vals);

        return node;
    }
}
