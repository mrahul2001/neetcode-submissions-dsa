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
    public int maxPathSum(TreeNode root) {
        int[] pathSum = new int[] {root.val};
        dfs(root, pathSum);

        return pathSum[0];
    }

    private int dfs(TreeNode node, int[] pathSum) {
        if (node == null)
            return 0;
        
        int leftPathMax = Math.max(dfs(node.left, pathSum), 0);
        int rightPathMax = Math.max(dfs(node.right, pathSum), 0);

        pathSum[0] = Math.max(pathSum[0], node.val + leftPathMax + rightPathMax);

        return node.val + Math.max(leftPathMax, rightPathMax);
    }
}
