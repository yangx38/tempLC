public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            sb.append(cur.val+" ");
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] str = data.split("\\s+");
        Queue<Integer> queue = new LinkedList<>();
        for(String s : str) queue.offer(Integer.valueOf(s));
        return helper(queue);
    }
    
    private TreeNode helper(Queue<Integer> queue) {
        if(queue.isEmpty()) return null;
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallQueue = new LinkedList<>();
        while(!queue.isEmpty() && queue.peek() < root.val) {
            smallQueue.offer(queue.poll());
        }
        root.left = helper(smallQueue);
        root.right = helper(queue);
        return root;
    }
}