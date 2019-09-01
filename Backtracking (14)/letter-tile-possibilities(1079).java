// T = n*T(n-1) = O(n!)
// S = O(n)
class Solution {
    int res = 0;
    public int numTilePossibilities(String tiles) {
        if(tiles == null || tiles.length() == 0) return 0;
        char[] sc = tiles.toCharArray();
        Arrays.sort(sc);
        helper(sc, new int[sc.length]);
        return res-1;
    }
    
    private void helper(char[] sc, int[] visited) {
        res++;
        for(int i = 0; i < sc.length; i++) {
            if(visited[i] == 1 || i > 0 && sc[i] == sc[i-1] && visited[i-1] == 0) continue;
            visited[i] = 1;
            helper(sc, visited);
            visited[i] = 0;
        }
    }
}