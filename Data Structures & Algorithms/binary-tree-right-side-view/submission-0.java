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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);

        return result;
    }

    private void dfs(TreeNode node, List<Integer> result, int depth) {
        if (node == null)
            return;
        
        if (depth == result.size())
            result.add(node.val);
        
        depth++;
        dfs(node.right, result, depth);
        dfs(node.left, result, depth);
    }
}
