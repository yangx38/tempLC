// T = O(nlogn)
// S = O(n)
class Solution {
    // cur:        a -- b
    // interval:       c-- d
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, (a, b)->(a[1]-b[1]));
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] cur = pq.poll();
            if(cur[1] <= interval[0]) cur[1] = interval[1];
            else pq.offer(interval);
            pq.offer(cur);
        }
        return pq.size();
    }
}