// T = O(m+n)
// S = O(m+n)
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0) return new int[0][0];
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < A.length && j < B.length) {
            int L = Math.max(A[i][0], B[j][0]);
            int R = Math.min(A[i][1], B[j][1]);
            if(L <= R) res.add(new int[]{L, R});
            if(A[i][1] <= B[j][1]) i++;
            else j++;
        }
        
        int[][] resArr = new int[res.size()][2];
        int k = 0;
        for(int[] r : res) resArr[k++] = r;
        return resArr;
    }
}