Question Link: https://leetcode.com/problems/check-completeness-of-a-binary-tree/



class Solution {
    public boolean isCompleteTree(TreeNode root) {
        final Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leaf = false;
        while(!q.isEmpty()) {
            final var node = q.poll();

            // Check if in leaf level righter nodes have children
            if(leaf && (node.left != null || node.right != null)) {
                return false;
            }

            // Check if left is empty and right has child
            if(node.left == null && node.right != null) {
                return false;
            }

            // Record leaf level reached
            if(node.left == null && node.right == null) {
                leaf = true;
            } else {
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }else {
                    leaf = true;
                }
            }
        }
        return true;
    }
}
