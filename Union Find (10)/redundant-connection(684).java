// T = O(n*amortized(n)) = about O(n)
// S = O(n)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0) return new int[0];
        UnionFind uf = new UnionFind(edges.length);
        for(int[] e : edges) {
            if(!uf.union(e[0], e[1])) return e;
        }
        return new int[0];
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
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
            rank[pu]++;
            parent[pv] = pu;
        }
        return true;
    }
}