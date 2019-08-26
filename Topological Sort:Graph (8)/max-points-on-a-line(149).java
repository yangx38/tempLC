// T = O(n^2)
// S = O(n)
class Solution {
    public int maxPoints(int[][] points) {
        if(points == null || points.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>(); // slope freq map
            int subres = 0, overlap = 0, vertical = 0;
            for(int j = i+1; j < points.length; j++) {
                if(points[i][0] == points[j][0]) {
                    if(points[i][1] == points[j][1]) overlap++;
                    else vertical++;
                    continue;
                }
                // get k - "dy/dx"
                int dx = points[i][0]-points[j][0];
                int dy = points[i][1]-points[j][1];
                int temp = gcd(dx, dy);
                dx /= temp; dy /= temp;
                String k = dy+"/"+dx;
                // update map
                map.put(k, map.getOrDefault(k, 0)+1);
                subres = Math.max(subres, map.get(k));
            }
            subres = Math.max(subres, vertical);
            res = Math.max(res, subres+overlap+1);
        }
        return res;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}