// bucket sort:
// bst/wst: T = O(n+m) / O(nlogn)
// S = O(n+m)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        
        List<String>[] bucket = new List[words.length + 1];
        for(String key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        List<String> res = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(res.size() >= k) break;
            if(bucket[i] != null) {
                Collections.sort(bucket[i]);
                res.addAll(bucket[i]);
            }
        }
        return res.subList(0, k);
    }
}

// pq 解法: 
// T = O(nlogk) 
// S = O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0)+1);
        
        PriorityQueue<Map.Entry<String, Integer>> pq = 
            new PriorityQueue<>((a, b)-> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        
        return res;
    }
}