// T = O(logn)
// S = O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int first = findFirst(nums, target);
        if(first == -1) return new int[]{-1, -1};
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    
    private int findFirst(int[] A, int target) {
        int L = 0, R = A.length-1;
        while(L < R-1) {
            int mid = (R-L)/2+L;
            if(A[mid] < target) L = mid;
            else R = mid;
        }
        if(A[L] == target) return L;
        if(A[R] == target) return R;
        return -1;
    }
    
    private int findLast(int[] A, int target) {
        int L = 0, R = A.length-1;
        while(L < R-1) {
            int mid = (R-L)/2+L;
            if(A[mid] > target) R = mid;
            else L = mid;
        }
        if(A[R] == target) return R;
        if(A[L] == target) return L;
        return -1;
    }
}