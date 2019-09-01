// T = O(n)
// S = O(n)
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long L = (long)lower, R = (long)upper;
        for(int num : nums) {
            if(L == num) L++;
            else if(L < num) {
                if(L+1 == num) res.add(L+"");
                else res.add(L+"->"+(num-1));
                L = (long)num+1;
            }
        }
        if(L == R) res.add(L+"");
        else if(L < R) res.add(L+"->"+R);
        
        return res;
    }
}