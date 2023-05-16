class Solution {
  int cnt = 0;

  public ListNode swapPairs(ListNode node) {
    if (node == null) return null;

    cnt++;
    var ret = swapPairs(node.next);

    if (cnt % 2 == 1 && ret != null) {
      // node -> the first (left) node in each pair
      node.next = ret.next;
      ret.next = node;
    } else {
      // node -> the second (right) node in each pair
      node.next = ret;
      ret = node;
    }
    cnt--;
    return ret;
  }
}
