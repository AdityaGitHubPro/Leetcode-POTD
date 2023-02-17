Question Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/



class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev;

    public int minDiffInBST(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        prev = node;
        inOrderTraversal(node.right);
    }
}
