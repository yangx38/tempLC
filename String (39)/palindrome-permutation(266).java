class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        for(int i = 0; i < sc.length; i++) {
            if(map[sc[i]] > 0) map[sc[i]]--;
            else map[sc[i]]++;
        }
        int time = 0;
        for(int i : map) {
            if(i != 0) time++;
        }
        return time <= 1;
    }
}