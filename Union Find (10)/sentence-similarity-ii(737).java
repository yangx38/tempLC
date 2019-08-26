// T = O(m+n) - m as # of pairs, n as length of words1
// S = O(m+n)  
class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;
        UnionFind uf = new UnionFind(pairs.size()*2);
        for(List<String> pair : pairs) {
            int firstId = getId(pair.get(0));
            int secondId = getId(pair.get(1));
            uf.union(firstId, secondId);
        }

        for(int i = 0; i < words1.length; i++) {
            if(words1[i].equals(words2[i])) continue;
            if(!map.containsKey(words1[i]) || !map.containsKey(words2[i])) return false;
            int words1Id = getId(words1[i]);
            int words2Id = getId(words2[i]);
            if(uf.find(words1Id) != uf.find(words2Id)) return false;
        }
        return true;
    }
    
    private int getId(String word) {
        if(map.containsKey(word)) return map.get(word);
        int id = map.size(); // largest 
        map.put(word, id);
        return id;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < parent.length; i++) {
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
        if(rank[pv] > rank[pu]) parent[pu] = pv;           
        else if(rank[pu] > rank[pv]) parent[pv] = pu;
        else {
            rank[pu]++;
            parent[pv] = pu;
        }
        return true;
    }
}