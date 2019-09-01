// T = O(|V|+|E|)
// S = O(n)
class Solution {
    public boolean canFinish(int num, int[][] prereq) {
        int[] degree = new int[num];
        int res = num; 
        for(int[] pair : prereq) {
            int classNumber = pair[0];
            degree[classNumber]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) queue.offer(i); 
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            res--;
            for(int[] pair : prereq) {
                if(pair[1] == cur) {
                    int classNumber = pair[0];
                    degree[classNumber]--; 
                    if(degree[classNumber] == 0) {
                        queue.offer(classNumber);
                    }
                }
            }
        }
        return res == 0;
    }
}