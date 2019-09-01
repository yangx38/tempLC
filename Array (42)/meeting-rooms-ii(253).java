// T = O(nlogn)
// S = O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            cur = pq.poll();
            if(interval[0] < cur[1]) {
                pq.offer(interval);
                pq.offer(cur);
            } else {
                cur[1] = Math.max(interval[1], cur[1]);
                pq.offer(cur);
            }
        }
        return pq.size();
    }
}