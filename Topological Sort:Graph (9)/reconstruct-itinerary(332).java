// T = O(n) + O(nlogn) + O(n!) = O(n!)
// S = O(n)
class Solution {
    Map<String, List<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    int totalLen = 0;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return null;
        totalLen = tickets.size()+1;
        for(List<String> ticket : tickets) {
            String u = ticket.get(0), v = ticket.get(1);
            if(!map.containsKey(u)) map.put(u, new ArrayList<>());
            map.get(u).add(v);
        }
        for(List<String> list : map.values()) Collections.sort(list);
        res.add("JFK");
        if(helper("JFK")) return res;
        return null;
    }
    
    private boolean helper(String u) {
        if(res.size() == totalLen) return true;
        if(!map.containsKey(u)) return false;
        List<String> vs = map.get(u);
        for(int i = 0; i < vs.size(); i++) {
            String v = vs.get(i);
            vs.remove(i);
            res.add(v);
            if(helper(v)) return true;
            res.remove(res.size()-1);
            vs.add(i, v);
        }
        return false;
    }
}

// T = O(n+nlogn)建图 + O(n)
// S = O(n)	
class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return new ArrayList<>();
        for(List<String> ticket : tickets) {
            String u = ticket.get(0), v = ticket.get(1);
            if(!map.containsKey(u)) map.put(u, new PriorityQueue<>());
            map.get(u).add(v);
        }
        dfs("JFK");
        return res;
    }
    
    private void dfs(String u) {
        while(map.containsKey(u) && !map.get(u).isEmpty()) {
            String v = map.get(u).poll();
            dfs(v);
        }
        res.add(0, u);
    }
}