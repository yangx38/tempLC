// T = O(n)
// S = O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0); dummy.next = head;
        ListNode fast = head, slow = dummy;
        while(fast != null && fast.next != null) {
            slow.next = slow.next.next;
            fast.next = fast.next.next;
            slow = slow.next;
            slow.next = fast;
            fast = fast.next; slow = slow.next;  
        }
        return dummy.next;
    }
}