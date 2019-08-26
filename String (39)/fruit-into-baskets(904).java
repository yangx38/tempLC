// T = O(n)
// S = O(1)
class Solution {
    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); // tree品种, freq
        // [L, R]
        int res = 0;
        for(int L = 0, R = 0; R < tree.length; R++) {
            map.put(tree[R], map.getOrDefault(tree[R], 0)+1);
            while(map.size() > 2) {
                map.put(tree[L], map.get(tree[L])-1);
                if(map.get(tree[L]) == 0) map.remove(tree[L]);
                L++;
            }
            res = Math.max(R-L+1, res);
        }
        return res;
    }
}