Question Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/



class Solution {
    int result = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int currSum) {
        if (node == null) return;

        currSum = currSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            result += currSum;
            return;
        }

        dfs(node.left, currSum);
        dfs(node.right, currSum);
    }
}
