/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
// time : O(n); space : O(n);
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>(); // org, copy
        Node cur = head;
        // |V|
        while(cur != null) {
            map.put(cur, new Node());
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null) {
            Node clone = map.get(cur);
            clone.val = cur.val;
            clone.next = map.get(cur.next);
            clone.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }   
}