public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int L = 1, R = n;
        while(L <= R) {
            int mid = (R-L)/2+L;
            if(guess(mid) == 0) return mid;
            else if(guess(mid) == 1) L = mid+1;
            else R = mid-1;
        }
        return -1;
    }
}