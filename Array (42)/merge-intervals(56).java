// T = O(nlogn) 
// S = O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b)->(a[0]-b[0]));
        int L = intervals[0][0], R = intervals[0][1];
        
        List<int[]> res = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            int[] newInt = intervals[i];
            if(newInt[0] <= R) R = Math.max(newInt[1], R);
            else {
                res.add(new int[]{L, R});
                L = newInt[0]; R = newInt[1];
            }
        }
        res.add(new int[]{L, R});
        
        int[][] resArr = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}