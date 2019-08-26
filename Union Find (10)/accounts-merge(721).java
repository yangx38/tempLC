// T = O(n)~O(nlogn) b/c TreeNode's add - n as sum # of emails
    // bst: all different - wrt: all same
// S = O(n)
class Solution {
    Map<String, List<Integer>> emailToId = new HashMap<>();
    UnionFind uf = null;
    Map<Integer, Set<String>> idToEmail = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts == null || accounts.size() == 0) return new ArrayList<>();
        convertToIds(accounts);
        uf = new UnionFind(accounts.size());
        union();
        convertToEmails(accounts);
        merge(accounts);
        return res;
    }
    
    private void convertToIds(List<List<String>> accounts) {
        for(int id = 0; id < accounts.size(); id++) {
            List<String> account = accounts.get(id);
            for(int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if(!emailToId.containsKey(email)) emailToId.put(email, new ArrayList<>());
                emailToId.get(email).add(id);
            }
        }
    }
    private void union() {
        for(List<Integer> ids : emailToId.values()) {
            if(ids.size() > 1) {
                for(int i = 1; i < ids.size(); i++) uf.union(ids.get(i), ids.get(0));
            }
        }
    }
    private void convertToEmails(List<List<String>> accounts) {
        for(int id = 0; id < accounts.size(); id++) {
            int rootId = uf.find(id);
            if(!idToEmail.containsKey(rootId)) idToEmail.put(rootId, new TreeSet<>());
            List<String> account = accounts.get(id);
            for(int i = 1; i < account.size(); i++) idToEmail.get(rootId).add(account.get(i));
        }
    }
    
    private void merge(List<List<String>> accounts) {
        for(Map.Entry<Integer, Set<String>> pair : idToEmail.entrySet()) {
            List<String> subres = new ArrayList<>();
            subres.add(accounts.get(pair.getKey()).get(0));
            subres.addAll(pair.getValue());
            res.add(subres);
        }
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