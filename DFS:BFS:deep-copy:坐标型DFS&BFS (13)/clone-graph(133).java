/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return helper(node);
    }
    
    private Node helper(Node node) {
        if(map.containsKey(node)) return map.get(node);
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        for(Node ne : node.neighbors) {
            copy.neighbors.add(helper(ne));
        }
        return map.get(node);
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        List<Node> nodes = bfs(node);
        Map<Node, Node> map = new HashMap<>();
        // V: 
        for(Node n : nodes) {
            map.put(n, new Node(n.val, new ArrayList<>()));
        }
        // E
        for(Node n : nodes) {
            Node dup = map.get(n);
            for(Node ne : n.neighbors) {
                dup.neighbors.add(map.get(ne));
            }
        }
        return map.get(node);
    }
    
    private List<Node> bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(node); set.add(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node ne : cur.neighbors) {
                if(!set.contains(ne)) {
                    set.add(ne);
                    queue.offer(ne);
                }
            }
        }
        return new ArrayList<>(set);
    }
}