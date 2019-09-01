// T = O(nlogn) 
// S = O(n)
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if(schedule == null || schedule.size() == 0) return new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)->{
            if(a.start < b.start) return -1;
            else if(a.start == b.start) return a.end-b.end;
            else return 1;
        });
        for(List<Interval> s : schedule) pq.addAll(s);

        Interval pre = pq.poll();
        int L = pre.start, R = pre.end;
        List<Interval> merged = new ArrayList<>();
        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if(cur.start <= R) {
                R = Math.max(cur.end, R);
            } else {
                merged.add(new Interval(L, R));
                L = cur.start; 
                R = cur.end;
            }
        }
        merged.add(new Interval(L, R));

        List<Interval> res = new ArrayList<>();
        for(int i = 1; i < merged.size(); i++) {
            res.add(new Interval(merged.get(i-1).end, merged.get(i).start));
        }
        return res;
    }
}
