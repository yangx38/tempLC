// T = O(1)
// S = O(1)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1];
        int x2 = rec1[2], y2 = rec1[3];
        
        int x3 = rec2[0], y3 = rec2[1];
        int x4 = rec2[2], y4 = rec2[3];
        
        return x3 < x2 && x1 < x4 && y1 < y4 && y3 < y2;
    }
}