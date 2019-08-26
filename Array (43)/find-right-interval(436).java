// T = O(nlogn) 
// S = O(n)
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i); // firstNum, index
        }
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key == null ? -1 : map.get(key);
        }
        return res;
    }
}