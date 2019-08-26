// T = O(n)
// S = O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;

        int[] map = new int[26];
        for(char task : tasks) {
            map[task-'A']++;
        }
        Arrays.sort(map);
        int i = 25;
        while(i >= 0 && map[25] == map[i]) i--;
        return Math.max(tasks.length, (n+1)*(map[25]-1)+25-i);
    }
}

// T = O(m+klogk) m as length of tasks, k as # of unique characters
// S = O(1) map and pq and queue size will not exceed O(26)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks) map.put(c, map.getOrDefault(c, 0)+1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        
        int res = 0;
        while(!pq.isEmpty()) {
            Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
            while(queue.size() != n+1 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> cur = pq.poll();
                cur.setValue(cur.getValue()-1);
                queue.offer(cur);
                res++;
            }
            int rest = n+1-queue.size();
            for(Map.Entry<Character, Integer> entry : queue) {
                if(entry.getValue() > 0) pq.offer(entry);
            }
            if(pq.isEmpty()) break;
            res += rest;
        }
        return res;
    }
}