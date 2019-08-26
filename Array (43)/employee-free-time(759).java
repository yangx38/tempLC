// T = O(nlogn) 
// S = O(n)
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule == null || schedule.size() == 0) return new ArrayList<>();
        
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)->(a.start - b.start));
        for(List<Interval> sc : schedule) pq.addAll(sc);
        
        int start = pq.peek().start, end = pq.peek().end;
        List<Interval> merged = new ArrayList<>();
        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if(cur.start <= end) end = Math.max(end, cur.end);
            else {
                merged.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        merged.add(new Interval(start, end));

        List<Interval> res = new ArrayList<>();
        for(int i = 0; i <= merged.size()-2;i++) {
            res.add(new Interval(merged.get(i).end, merged.get(i+1).start));
        }
        return res;
    }
}

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        if (schedule == null || schedule.size() == 0) return res;
        Queue<Interval> pq = new PriorityQueue<>((a, b)->(a.start - b.start));
        for(List<Interval> sc : schedule) pq.addAll(sc);

        int end = pq.peek().end;
        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if(cur.start <= end) end = Math.max(end, cur.end);
            else {
                res.add(new Interval(end, cur.start));
                end = cur.end;
            }
        }
        
        return res;
    }
}