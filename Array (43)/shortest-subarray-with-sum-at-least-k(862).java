// T = O(n)
// S = O(n)
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] sum = new int[A.length+1];
        for(int i = 0; i < A.length; i++) sum[i+1] = sum[i] + A[i];
        Deque<Integer> monoq = new LinkedList();

        int res = Integer.MAX_VALUE;
        for(int m = 0; m < sum.length; m++) { 
            while(!monoq.isEmpty() && sum[monoq.getLast()] >= sum[m]) monoq.pollLast();
            while(!monoq.isEmpty() && sum[m]-sum[monoq.getFirst()] >= K) {
                int n = monoq.pollFirst();
                res = Math.min(res, m-n);
            }
            monoq.addLast(m);
            // for(Integer  mono : monoq) System.out.print(mono);
            // System.out.println();
        }
        return res <= A.length ? res : -1;
    }
}