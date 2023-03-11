Question Link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/


class Solution {
    private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        current = head;
        return buildBST(0, size - 1);
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    
    private TreeNode buildBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = buildBST(start, mid - 1);
        TreeNode node = new TreeNode(current.val);
        current = current.next;
        TreeNode right = buildBST(mid + 1, end);
        node.left = left;
        node.right = right;
        return node;
    }
}
