// T = O(logn)
// S = O(1)
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 1) return true;
        long L = 1, R = num;
        while(L < R-1) {
            long mid = (R-L)/2+L;
            if(mid*mid == num) return true;
            else if(mid*mid < (num)) L = mid;
            else R = mid;
        }
        if(L*L == num || R*R == num) return true;
        return false;
    }
}