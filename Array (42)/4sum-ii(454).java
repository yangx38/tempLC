// T = O(n^2)
// S = O(n^2)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int a : A) {
            for(int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        for(int c : C) {
            for(int d : D) {
                int sum = -c - d;
                if(map.containsKey(sum)) res += map.get(sum);
            }
        }
        return res;
    }
}