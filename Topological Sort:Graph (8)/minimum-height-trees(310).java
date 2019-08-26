// T = O(|E|+|V|)
// S = O(n)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 0) return new ArrayList<>();
        if(n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        
        List<Integer>[] children = new List[n];
        for(int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            children[u].add(v);
            children[v].add(u);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(children[i].size() == 1) leaves.add(i);
        }
        
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer oldLeave : leaves) {
                List<Integer> connected = children[oldLeave];
                for(Integer node : connected) {
                    children[node].remove(oldLeave);
                    if(children[node].size() == 1) newLeaves.add(node);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}