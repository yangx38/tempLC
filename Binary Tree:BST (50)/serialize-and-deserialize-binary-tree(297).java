// T = O(n)
// S = O(n)
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur == null) {
                    sb.append("null ");
                    continue;
                }
                sb.append(cur.val+" ");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] str = data.split("\\s+");
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 1; i < str.length; i++) {
            TreeNode cur = queue.poll();
            if(!str[i].equals("null")) {
                cur.left = new TreeNode(Integer.valueOf(str[i]));
                queue.offer(cur.left);
            }
            i++;
            if(!str[i].equals("null")) {
                cur.right = new TreeNode(Integer.valueOf(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));