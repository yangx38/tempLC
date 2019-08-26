// T = O(n)
// S = O(1)
class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = -1, res = 0;
        if(seats[0] == 1) i = 0;
        for(int j = 0; j < seats.length; j++) {
            if(seats[j] == 1) {
                // two ways of updating res
                if(i == -1) res = Math.max(res, j);
                else res = Math.max(res, (j-i)/2);
                i = j;
            }
        }
        if(seats[seats.length-1] == 0) res = Math.max(res, seats.length-1-i);
        return res;
    }
}