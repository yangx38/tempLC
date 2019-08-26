// T = O(n)
// S = O(10000)
class MyHashSet {
    List<Integer>[] nodes;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        nodes = new List[10000];
    }
    
    public void add(int key) {
        int id = hash(key);
        if(nodes[id] == null) nodes[id] = new ArrayList<>();
        for(int i = 0; i < nodes[id].size(); i++) {
            if(nodes[id].get(i) == key) return;
        }
        nodes[id].add(key);
    }
    
    public void remove(int key) {
        int id = hash(key);
        if(nodes[id] == null) return;
        for(int i = 0; i < nodes[id].size(); i++) {
            if(nodes[id].get(i) == key) {
                nodes[id].remove(i);
                return;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int id = hash(key);
        if(nodes[id] == null) return false;
        for(int i = 0; i < nodes[id].size(); i++) {
            if(nodes[id].get(i) == key) return true;
        }
        return false;
    }
    
    private int hash(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */