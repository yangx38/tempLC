// T = O(n)
// S = O(n)
class Codec {
    public TreeNode encode(Node root) {
        if(root == null) return null;
        TreeNode res = new TreeNode(root.val);
        if(root.children.size() > 0) res.right = encode(root.children.get(0));
        TreeNode cur = res.right;
        for(int i = 1; i < root.children.size(); i++) {
            cur.left = encode(root.children.get(i));
            cur = cur.left;
        }
        return res;
    }

    public Node decode(TreeNode root) {
        if(root == null) return null;
        Node res = new Node(root.val, new LinkedList<>());
        TreeNode cur = root.right;
        while(cur != null) {
            res.children.add(decode(cur));
            cur = cur.left;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));