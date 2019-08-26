// T = O(logn) worst case: O(n)
// S = O(h)
class Solution {
    public Node inorderSuccessor(Node x) {
        if(x.right != null) {
            Node cur = x.right;
            while(cur.left != null) cur = cur.left;
            return cur;
        }
        else {
            Node cur = x;
            while(cur.parent != null && cur.parent.right == cur) cur = cur.parent;
            return cur.parent;
        }
    }
}