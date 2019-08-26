// T = O(1)
// S = O(n) n as capacity
class LRUCache {
    Map<Integer, Node> map;
    int capacity, size;
    Node head, tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity; size = 0;
        head = new Node(); tail = new Node();
        head.next = tail; tail.pre = head;
    }
    
    public int get(int key) {
        if(capacity == 0) return -1;
        Node node = map.get(key);
        if(node == null) return -1;
        // if already first element, just return
        if(node.pre == head) return node.val;
        remove(node);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        Node node = map.get(key);
        if(node == null) {
            // create new node
            node = new Node(key, value); size++;
            moveToHead(node);
            if(size > capacity) {
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            map.put(key, node);
            return;
        }
        node.val = value;
        if(node == head.next) return;
        remove(node);
        moveToHead(node);
    }
    
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void moveToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    
    class Node {
        int key, val;
        Node next, pre;
        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */