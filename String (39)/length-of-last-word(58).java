// T = O(n)
// S = O(n)
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        String[] sp = s.split("\\s+");
        if(sp.length == 0) return 0;
        return sp[sp.length-1].length();
    }
}