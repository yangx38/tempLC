class MyLinkedList {
    Node head, tail;
    int size = 0;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node cur = head;
        while(index-- >= 0) cur = cur.next;
        return cur.val;
    }
    
    /** Add a node of vaglue val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
     // corrected my code to insert negative index at head, then it passed. This semantic should be added to the description.
    public void addAtIndex(int index, int val) {
        if(index < 0) {
            addAtHead(val);
            return;
        }
        if(index > size) return;
        Node cur = head;
        while(--index >= 0) cur = cur.next;
        Node newNode = new Node(val);
        newNode.next = cur.next;
        newNode.pre = cur;
        cur.next.pre = newNode;
        cur.next = newNode;
        
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(size == 0 || index < 0 || index >= size) return;
        Node cur = head;
        while(index-- >= 0) cur = cur.next;
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        size--;
    }
    
    class Node {
        int val;
        Node pre = null, next = null;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */