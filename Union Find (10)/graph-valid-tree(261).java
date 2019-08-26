// T = O(n*amortized(n)) = smaller than O(nlogn)
// S = O(n)
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null) return false;
        if(n == 1 && edges.length == 0) return true;
        if(edges.length != n-1) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] e : edges) {
            if(!uf.union(e[0], e[1])) return false;
        }
        return true;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
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