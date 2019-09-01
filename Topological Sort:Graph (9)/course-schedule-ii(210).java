// T = O(|V|+|E|)
// S = O(n)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[] res = new int[numCourses];

        for(int[] pair : prerequisites) {
            int courseNumber = pair[0];
            degree[courseNumber]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int k = 0; // k as res's pointer
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int[] pair : prerequisites) {
                int courseNumber = pair[0];
                if(pair[1] == cur) {
                    degree[courseNumber]--;
                    // if reach 0, then add to queue
                    if(degree[courseNumber] == 0) {
                        queue.offer(courseNumber);
                        res[k++] = pair[0];
                    }
                }
            }
        }
        return (k == numCourses) ? res : new int[0];
    }
}