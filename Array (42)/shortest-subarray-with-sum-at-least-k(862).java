// T = O(n)
// S = O(n)
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] sum = new int[A.length+1];
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1]+A[i-1];
        }
        
        // find min m-n, st. sum[m]-sum[n] >= k sum[n]尽量小, n尽量大, sum[m]尽量大, m尽量小
        int res = Integer.MAX_VALUE;
        Deque<Integer> monoq = new LinkedList<>();
        for(int m = 0; m < sum.length; m++) { 
            while(!monoq.isEmpty() && sum[m]-sum[monoq.getFirst()] >= K) {
                int n = monoq.pollFirst();
                res = Math.min(res, m-n);
            }
            // update n: sum[oldN] >= sum[newN] 
            while(!monoq.isEmpty() && sum[monoq.getLast()] >= sum[m]) monoq.pollLast();
            monoq.addLast(m);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
