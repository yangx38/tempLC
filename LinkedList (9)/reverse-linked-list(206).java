// T = O(n)
// S = O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = temp;
            temp = cur;
            cur = next;
        }
        return temp;
    }
}