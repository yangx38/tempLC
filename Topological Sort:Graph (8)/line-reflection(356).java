// T = O(n)
// S = O(n)
class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0) return true;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for(int[] point : points) {
            max = Math.max(point[0], max);
            min = Math.min(point[0], min);
            set.add(point[0]+","+point[1]);
        }
        int mid = max+min;
        for(int[] point : points) {
            String reflect = (mid-point[0])+","+point[1];
            if(!set.contains(reflect)) return false;
        }
        return true;
    }
}