// T = O(n)
// S = O(n/k)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0; ListNode cur = head;
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        cur = reverseKGroup(cur, k);
        
        if(count < k) return head;
        for(int i = 0; i < k; i++) {
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return cur;
    }
}