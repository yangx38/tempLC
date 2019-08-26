// T = O(n*amortized(n)) = about O(n)
// S = O(n)
class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(M[i][j] == 1) uf.union(i, j);
            }
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