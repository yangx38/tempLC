// T = O(n)
// S = O(n)
class HitCounter {
    Queue<Integer> queue;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp-queue.peek() >= 300) queue.poll();
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

// T = O(n)
// S = O(1)
class HitCounter {
    private int[] times;
    private int[] hits;

    public void DesignHitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int id = timestamp % 300;
        if(times[id] != timestamp) {
            times[id] = timestamp;
            hits[id] = 1;
        } else {
            hits[id]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for(int i = 0; i < 300; i++) {
            if(timestamp - times[i] < 300) res += hits[i];
        }
        return res;
    }
}