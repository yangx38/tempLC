// T = O(k amortized(mn)) ie. b/t O(k) ~ O(klog(mn)) - k: length of positions
// S = O(mn)
class Solution {
    List<Integer> res = new ArrayList<>();
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if(m == 0 || n == 0 || positions == null || positions.length == 0) return res;
        UnionFind uf = new UnionFind(m*n);
        for(int[] pos : positions) {
            int id = pos[0]*n+pos[1];
            uf.set(id);
            for(int[] d : dirs) {
                int newI = pos[0]+d[0], newJ = pos[1]+d[1];
                if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
                int newId = newI*n+newJ;
                if(uf.find(newId) == -1) continue;
                uf.union(id, newId);
            }
            res.add(uf.count);
        }
        return res;
    }
}

class UnionFind {
    int[] parent, rank;
    int count = 0;
    
    public UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new int[n];
    }
    
    public void set(int id) {
        if(rank[id] == 0) {
            rank[id]++;
            parent[id] = id;
            count++;
        }
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
        count--;
        return true;
    }
    
    public int find(int id) {
        if(parent[id] == -1) return -1;
        if(id != parent[id]) parent[id] = find(parent[id]);
        return parent[id];
    }
}