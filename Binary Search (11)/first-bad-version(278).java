// T = O(logn)
// S = O(1)
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1) return 1;
        int L = 1, R = n;
        while(L < R-1) {
            int mid = L+(R-L)/2;
            if(!isBadVersion(mid)) L = mid;
            else R = mid;
        }
        if(isBadVersion(L)) return L;
        return R;
    }
}