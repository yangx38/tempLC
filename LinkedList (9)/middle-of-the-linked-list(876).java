class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode s = head, f = head;
        while(s.next != null && s.next.next != null) {
            f = f.next;
            s = s.next.next;
        }
        return s.next == null ? f : f.next;
    }
}