// T = O(nlogn)
// S = O(1)
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int L = 0, R = A.length-1;
        int res = -1;
        while(L < R) {
            int cur = A[L]+A[R];
            if(cur < K) {
                if(Math.abs(K-cur) < Math.abs(K-res)) res = cur;
                L++;
            } else R--;
        }
        return res;
    }
}