Question Link: https://leetcode.com/problems/linked-list-cycle-ii/



public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr1 = head;
                ListNode ptr2 = slow;
                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
            }
        }
        return null;
    }
}
