// bucket sort: 
// T = O(n+m) n as len of nums && m as len of bucket
// S = O(n+m)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        
        List<Integer>[] bucket = new List[nums.length+1];
        for(Integer num : map.keySet()) {
            int freq = map.get(num);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(num);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length-1; i >= 0; i--) {
            if(res.size() >= k) break;
            if(bucket[i] != null) res.addAll(bucket[i]);
        }
        return res.subList(0, k);
    }
}

// pq 解法:
// T = O(nlogk)   
// S = O(n)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : pq) res.add(entry.getKey());
        return res;
    }
}