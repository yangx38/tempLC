// T = O(n)
// S = O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode smallHead = new ListNode(0), bigHead = new ListNode(0);
        ListNode sp = smallHead, bp = bigHead;
        while(head != null) {
            if(head.val < x) {
                sp.next = head;
                sp = sp.next;
            }
            else {
                bp.next = head;
                bp = bp.next;
            }
            head = head.next;
        }
        bp.next = null;
        sp.next = bigHead.next;
        return smallHead.next;
    }
}