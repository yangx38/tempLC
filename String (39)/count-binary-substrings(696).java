// T = O(n)  
// S = O(n)
class Solution {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] sArr = new int[s.length()];
        sArr[0] = 1;
        int index = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) sArr[index]++;
            else {
                index++; // get new index
                sArr[index] = 1;
            }
        }
        int res = 0;
        for(int i = 1; i <= index; i++) {
            res += Math.min(sArr[i-1], sArr[i]);
        }
        return res;
    }
}

// T = O(n)   
// S = O(1) by rolling array
class Solution {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int cur = 1, pre = 0, res = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }
}