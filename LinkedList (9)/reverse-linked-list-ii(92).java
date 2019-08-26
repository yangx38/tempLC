// T = O(n)
// S = O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0); dummy.next = head;

        ListNode pre = dummy, cur = head;
        for(int i = 0; i < m-1; i++) {
            pre = pre.next; 
            cur = cur.next;
        }
        
        for(int i = 0; i < n-m; i++) {
            ListNode ne = cur.next;
            cur.next = ne.next;
            ne.next = pre.next;
            pre.next = ne;
        }
        return dummy.next;
    }
}