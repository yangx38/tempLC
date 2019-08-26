// T = O(n*amortized(n)) = ~O(n)
// S = O(n) 
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if(edges == null || edges.length == 0) return new int[0];
        // detect入度为2的节点
        int[] first = new int[]{-1, -1}, second = new int[]{-1, -1};
        int[] parent = new int[edges.length+1];
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if(parent[v] != 0) {
                first = new int[]{parent[v], v};
                second = new int[]{u, v};
                edge[0] = -1; edge[1] = -1;
            }
            parent[v] = u;
        }
        System.out.println(Arrays.toString(first)); // 
        System.out.println(Arrays.toString(second));
        // detect环
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge : edges) {
            if(edge[0] == -1 && edge[1] == -1) continue;
            if(!uf.union(edge[0], edge[1])) {
                return first[0] == -1 ? edge : first; // why not second???
            }
        }
        
        System.out.println("a");
        return second;
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