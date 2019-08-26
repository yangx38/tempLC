// T = O(n^2) b/c ArrayList remove() T is O(n)
// S = O(n)
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) nums.add(i);
        int[] factorial = new int[n]; // [0!, 1!, 2!]
        factorial[0] = 1;
        for(int i = 1; i < n; i++) factorial[i] = factorial[i-1]*i;
        k--;
        
        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(nums.get(index));
            nums.remove(index);
            k = k % factorial[i];
        }
        return sb.toString();
    }
}