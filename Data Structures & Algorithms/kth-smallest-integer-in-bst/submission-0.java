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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();

        int cnt = 0;
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            cnt++;
            curr = st.pop();
            if (cnt == k)
                return curr.val;
            curr = curr.right;
        }

        return -1;
    }
}
