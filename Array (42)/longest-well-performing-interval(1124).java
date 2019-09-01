// T = O(n)
// S = O(n) worst case: all element <= 8
class Solution {
    public int longestWPI(int[] hours) {
        if(hours == null || hours.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int curSum = 0, res = 0;
        for(int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
            curSum += hours[i];
            if(curSum > 0) {
                res = i+1; 
                continue;
            }
            if(map.containsKey(curSum-1)) res = Math.max(res, i-map.get(curSum-1)); // [index+1, i]
            map.putIfAbsent(curSum, i);
            
        }
        return res;
    }
}