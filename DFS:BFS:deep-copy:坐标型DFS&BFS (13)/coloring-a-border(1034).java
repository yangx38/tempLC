// T = O(m*n)
// S = O(m*n)
class Solution {
    int m, n, c;
    int[][] visited;
    Set<int[]> set = new HashSet<>(); // border
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid == null || grid.length == 0) return new int[0][0];
        m = grid.length; n = grid[0].length; c = grid[r0][c0];
        visited = new int[m][n];
        helper(grid, r0, c0);
        for(int[] s : set) {
            grid[s[0]][s[1]] = color;
        }
        return grid;
    }
    
    private void helper(int[][] grid, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(visited[i][j] == 1) return;
        visited[i][j] = 1;
        for(int[] d : dirs) {
            int newI = i+d[0], newJ = j+d[1];
            if(newI < 0 || newI >= m || newJ < 0 || newJ >= n || grid[newI][newJ] != c) {
                set.add(new int[]{i, j});
                continue;
            }
            helper(grid, newI, newJ);
        }
    }
}