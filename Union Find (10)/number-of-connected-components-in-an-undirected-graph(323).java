// T = O(n*amortized(n)) = about O(n)
// S = O(n)
class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0 || edges[0].length == 0) return n;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    int count;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int id) {
        if(id != parent[id]) parent[id] = find(parent[id]);
        return parent[id];
    }
    
    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if(pu == pv) return false;
        if(rank[pu] < rank[pv]) parent[pu] = pv;
        else if(rank[pv] < rank[pu]) parent[pv] = pu;
        else {
            rank[pv]++;
            parent[pu] = pv;
        }
        count--;
        return true;
    }
}