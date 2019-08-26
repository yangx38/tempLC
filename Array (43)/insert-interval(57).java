// T = O(n)
// S = O(n)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval == null || newInterval.length == 0) return intervals;
        List<int[]> res = new ArrayList<>();
        
        int i = 0; 
        while(i < intervals.length && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i < intervals.length) res.add(intervals[i++]);
        
        int[][] resArr = new int[res.size()][2];
        for(int j = 0; j < res.size(); j++) {
            resArr[j] = res.get(j);
        }
        return resArr;
    }
}