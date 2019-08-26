// T = O(nlogk) n as total # of nodes, k as lists.length
// S = O(n+k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)-> a.val-b.val);
        for(ListNode list : lists) {
            if(list != null) pq.offer(list);
        }
        ListNode dummy = new ListNode(0), cur = dummy;
        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            cur.next = temp; cur = cur.next;
            if(temp.next != null) pq.offer(temp.next);
        }
        return dummy.next;
    }
}