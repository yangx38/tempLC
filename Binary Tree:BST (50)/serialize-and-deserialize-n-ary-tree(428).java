// T = O(n)
// S = O(n)
class Codec {
    List<String> res = new ArrayList<>();
    public String serialize(Node root) {
        if(root == null) return "";
        serHelper(root);
        return String.join(",", res);
    }

    private void serHelper(Node root) {
        if(root == null) return;
        res.add(String.valueOf(root.val));
        res.add(String.valueOf(root.children.size()));
        for(Node c : root.children) serHelper(c);
    }
    
    public Node deserialize(String data) {
        if(data.length() == 0) return null;
        String[] str = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(str));
        return desHelper(queue);
    }
    
    private Node desHelper(Queue<String> queue) {
        if(queue.isEmpty()) return null;
        Node root = new Node(Integer.valueOf(queue.poll()), new LinkedList<>());
        int size = Integer.valueOf(queue.poll());
        for(int i = 0; i < size; i++) {
            root.children.add(desHelper(queue));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));