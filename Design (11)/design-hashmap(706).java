// T = O(n)
// S = O(10000)
class MyHashMap {
    final Node[] nodes;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int id = hash(key);
        if(nodes[id] == null) nodes[id] = new Node(-1, -1);
        Node pre = findPre(nodes[id], key);
        if(pre.next == null) pre.next = new Node(key, value);
        else pre.next.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int id = hash(key);
        if(nodes[id] == null) return -1;
        Node pre = findPre(nodes[id], key);
        return pre.next == null ? -1 : pre.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int id = hash(key);
        if(nodes[id] == null) return;
        Node pre = findPre(nodes[id], key);
        if(pre.next == null) return;
        pre.next = pre.next.next;
    }
    
    private Node findPre(Node node, int key) {
        Node cur = node, pre = null;
        while(cur != null && cur.key != key) {
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
    
    private int hash(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    class Node {
        int key, val;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */