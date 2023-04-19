class Solution {
    int MAX;
    Map<TreeNode, int []> dp;
    public int longestZigZag(TreeNode root) {
        
        //postorder traversal
        //Map stores left from node and right from node
        dp = new HashMap<>();
        dfs(root);
        return MAX;
    }

    //returns max length from here if you go in a particular direction
    private void dfs(TreeNode root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            dp.put(root, new int[]{0,0});
            return;
        }
        //In dp value int []
        //index 0 represents left direction
        //index 1 represents right direction
        dfs(root.left);
        dfs(root.right);

        int left = 0, right = 0;

        if(dp.get(root.left) != null)
            left = 1 + dp.get(root.left)[1]; //we go right after left
        
        if(dp.get(root.right) != null)
            right = 1 + dp.get(root.right)[0]; //we go left after right
        dp.put(root, new int[]{left, right});
        MAX = Math.max(MAX, Math.max(left,right));
    }
}
