// T = O(logn)
// S = O(1)
class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        long L = 1, R = x-1;
        while(L < R-1) {
            long mid = (R-L)/2+L;
            if(mid*mid > x) R = mid;
            else L = mid;
        }
        if(R*R <= x) return (int)R;
        return (int)L;
    }
}