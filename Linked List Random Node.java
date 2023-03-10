Question Link: https://leetcode.com/problems/linked-list-random-node/



class Solution {

    private ListNode head;
    private Random rand;
    
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    public int getRandom() {
        ListNode curr = head;
        int result = curr.val;
        for (int i = 1; curr.next != null; i++) {
            curr = curr.next;
            if (rand.nextInt(i + 1) == i) {
                result = curr.val;
            }
        }
        return result;
    }
}
