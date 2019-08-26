// T = O(m*n)
// S = O(m*n)
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        int m = rooms.length, n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            for(int[] d : dirs) {
                int newI = i+d[0], newJ = j+d[1];
                if(newI < 0 || newI >= m || newJ < 0 || newJ >= n) continue;
                if(rooms[newI][newJ] <= rooms[i][j]+1) continue;
                queue.offer(new int[]{newI, newJ});
                rooms[newI][newJ] = rooms[i][j]+1;
            }
        }
    }
}