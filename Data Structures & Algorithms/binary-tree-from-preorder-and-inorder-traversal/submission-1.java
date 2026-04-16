class Solution {
    int preInd = 0;
    int inInd = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit) {
        if (preInd >= preorder.length)
            return null;

        if (inorder[inInd] == limit) {
            inInd++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preInd]);
        preInd++;
        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, limit);

        return root;
    }
}