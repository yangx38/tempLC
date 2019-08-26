// T = O(n)
// S = O(1)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length <= 1) return true;
        int[] map = new int[26];
        char[] oc = order.toCharArray();
        for(int i = 0; i < oc.length; i++) map[oc[i]-'a'] = i;
        
        for(int i = 1; i < words.length; i++) {
            char[] pre = words[i-1].toCharArray();
            char[] cur = words[i].toCharArray();
            int k = 0;
            while(k < pre.length && k < cur.length) {
                int preOrder = map[pre[k]-'a'];
                int curOrder = map[cur[k]-'a'];
                if(preOrder > curOrder) return false;
                else if(preOrder == curOrder) k++;
                else break;
            }
            if(pre.length > cur.length && k == cur.length) return false;
        }
        return true;
    }
}