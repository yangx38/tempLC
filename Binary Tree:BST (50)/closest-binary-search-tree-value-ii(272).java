// Brute Force:
// T = O(nlogk); S = O(h+k)
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if(root == null || k == 0) return new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            if(Math.abs(b-target)-Math.abs(a-target) > 0) return 1;
            else return -1;
        });
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                pq.offer(cur.val);
                if(pq.size() > k) pq.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        return new ArrayList<>(pq);
    }
}

// in-order traversal: 
// T = O(n)  S = O(h+k)
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        helper(root, target, k);
        return res;
    }

    private void helper(TreeNode root, double target, int k) {
        if(root == null) return;
        helper(root.left, target, k);
        if(res.size() == k) {
            if(Math.abs(target-root.val) < Math.abs(target-res.get(0))) res.remove(0);
            else return;
        }
        res.add(root.val);
        helper(root.right, target, k);
    }
}


// T = O(klogn)
// S = O(h+k)
class Solution {
    Stack<TreeNode> pre = new Stack<>();
    Stack<TreeNode> succ = new Stack<>();
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if(root == null) return res;
        initPre(root, target);
        initSucc(root, target);
        if(!pre.isEmpty() && !succ.isEmpty() && pre.peek().val == succ.peek().val) {
            helper(succ, true);
        }
        for(int i = 0; i < k; i++) {
            if(pre.isEmpty()) res.add(helper(succ, true));
            else if(succ.isEmpty()) res.add(helper(pre, false));
            else {
                double preDiff = Math.abs(pre.peek().val-target);
                double succDiff = Math.abs(succ.peek().val-target);
                if(preDiff < succDiff) res.add(helper(pre, false));
                else res.add(helper(succ, true));
            }
        }
        return res;
    }
    
    private int helper(Stack<TreeNode> stack, boolean isSucc) {
        TreeNode cur = stack.pop();
        int res = cur.val;
        if(isSucc) cur = cur.right;
        else cur = cur.left;
        
        while(cur != null) {
            stack.push(cur);
            if(isSucc) cur = cur.left;
            else cur = cur.right;
        }
        return res;
    } 
    
    private void initPre(TreeNode root, double target) {
        while(root != null) {
            if(root.val == target) {
                pre.push(root);
                break;
            }
            else if(root.val < target) {
                pre.push(root);
                root = root.right;
            } else root = root.left;
        }
    }
    
    private void initSucc(TreeNode root, double target) {
        while(root != null) {
            if(root.val == target) {
                succ.push(root);
                break;
            }
            else if(root.val > target) {
                succ.push(root);
                root = root.left;
            } else root = root.right;
        }
    }
}