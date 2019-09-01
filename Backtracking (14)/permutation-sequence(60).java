// T = O(n^2) b/c ArrayList remove() T is O(n)
// S = O(n)
class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < fact.length; i++) fact[i] = fact[i-1]*i;
        
        List<Integer> num = new ArrayList<>();
        for(int i = 1; i <= n; i++) num.add(i);
        
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = fact.length-1; i >= 0; i--) {
            int idx = k/fact[i];
            k %= fact[i];
            sb.append(num.get(idx));
            num.remove(idx);
        }
        
        return sb.toString();
    }
}