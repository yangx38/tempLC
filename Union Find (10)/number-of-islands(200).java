// T = O(m*n*amortized(m*n)) = about O(m*n)
// S = O(m*n)

class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        UnionFind uf = new UnionFind(grid);
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    for(int[] d : dirs) {
                        int newI = i+d[0], newJ = j+d[1];
                        boolean invalid = newI < 0 || newI >= m || newJ < 0 || newJ >= n || grid[newI][newJ] == '0';
                        if(!invalid) uf.union(i*n+j, newI*n+newJ);
                    }
                }
            }
        }
        return uf.count;
    }
}

class UnionFind {
    int[] parent;
    int[] rank; 
    int count = 0;
    
    public UnionFind(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m*n];
        rank = new int[m*n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    int id = i*n+j;
                    parent[id] = id;
                    count++;
                }
            }
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