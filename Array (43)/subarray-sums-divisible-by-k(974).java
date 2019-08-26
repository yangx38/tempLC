// T = O(n)
// S = O(n)
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); map.put(0, 1);
        int res = 0, curMod = 0;
        for(int i = 0; i < A.length; i++) {
            curMod += A[i];
            curMod = curMod % K;
            if(curMod < 0) curMod += K;
            if(map.containsKey(curMod)) res += map.get(curMod);
            map.put(curMod, map.getOrDefault(curMod, 0)+1);
        }
        return res;
    }
}