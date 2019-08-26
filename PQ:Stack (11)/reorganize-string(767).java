// T = O(nlogk)
// S = O(k)
class Solution {
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : S.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            
            if(sb.length() == 0 || sb.charAt(sb.length()-1) != cur.getKey()) {
                sb.append(cur.getKey());
                cur.setValue(cur.getValue()-1);
                if(cur.getValue() > 0) pq.offer(cur);
            }
            else {
                Map.Entry<Character, Integer> next = pq.poll();
                if(next == null) return "";
                sb.append(next.getKey());
                next.setValue(next.getValue()-1);
                if(next.getValue() > 0) pq.offer(next);
                pq.offer(cur);
            }
        }
        return sb.toString();
    }
}