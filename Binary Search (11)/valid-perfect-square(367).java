// T = O(logn)
// S = O(1)
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) return true;
        int L = 0, R = num-1;
        while(L < R-1) {
            long mid = (R-L)/2+L;
            if(mid*mid == num) return true;
            else if(mid*mid < num) L = (int)mid;
            else R = (int)mid;
        }
        if(L*L == num || R*R == num) return true;
        return false;
    }
}