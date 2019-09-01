// pq解法: 
// T = O(nlogk) 
// S = O(k)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length < K || points[0].length != 2) return new int[0][0];
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b)->b.dist-a.dist);
        for(int[] point : points) {
            pq.offer(new Point(point[0], point[1]));
            if(pq.size() > K) pq.poll();
        }
        
        int[][] res = new int[K][2];
        int i = 0;
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            res[i][0] = p.x;
            res[i++][1] = p.y;
        }
        return res;
    }
    
    class Point {
        int x, y;
        int dist;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = x*x+y*y;
        }
    }
}

// partition解法: 
// bst/wst/ave: T = O(nlogn)/O(n^2)/O(nlogn)
// bst/wst/ave: S = O(logn)/O(n)/O(logn)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length < K || points[0].length != 2) return new int[0][0];
        int L = 0, R = points.length-1;
        while(true) {
            int pos = partition(points, L, R);
            if(pos == K-1) break;
            else if(pos < K-1) L = pos+1;
            else R = pos-1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int partition(int[][] A, int L, int R) {
        int mid = L+(R-L)/2;
        int[] pivot = A[mid];
        swap(A, mid, L);
        int i = L+1, j = R;
        while(i <= j) {
            if(compare(A[i], pivot) > 0 && compare(A[j], pivot) < 0) swap(A, i++, j--);
            if(compare(A[i], pivot) <= 0) i++;
            if(compare(A[j], pivot) >= 0) j--;
        }
        swap(A, L, j);
        return j;
    }
    
    private void swap(int[][] A, int i, int j) {
        int[] temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    private int compare(int[] p1, int[] p2) {
        return p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1];
    }
}