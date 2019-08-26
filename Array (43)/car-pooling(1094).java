// T = O(nlogn)
// S = O(n)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips == null || trips.length == 0) return true;
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0)+trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0)-trip[0]);
        }
        int sum = 0;
        for(int val : map.values()) {
            sum += val;
            if(sum > capacity) return false;
        }
        return true;
    }
}