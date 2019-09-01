// T = O(logn)
// S = O(1)
class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        long L = 1, R = x;
        while(L < R-1) {
            long mid = (R-L)/2+L;
            if(mid*mid > x) R = mid;
            else L = mid;
        }
        if(L*L <= x) return (int)L;
        return (int)R;
    }
}