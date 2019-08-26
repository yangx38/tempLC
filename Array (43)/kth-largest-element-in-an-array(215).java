// pq解法: 
// T = O(nlogk)
// S = O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.poll(); //minHeap.peek() also work
    }
}

// partition解法:
// best/wst/ave T = O(nlogn) / O(n^2) / O(nlogn)
// best/wst/ave S = O(logn) / O(n) / O(logn)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int L = 0, R = nums.length-1;
        while(true) {
            int pos = partition(nums, L, R);
            if(pos == k-1) return nums[pos];
            else if(pos > k-1) R = pos-1;
            else L = pos+1;
        }
    }
    
    private int partition(int[] A, int L, int R) {
        int mid = L+(R-L)/2;
        int pivot = A[mid];
        swap(A, mid, L);
        int i = L+1, j = R;
        while(i <= j) {
            if(A[i] < pivot && A[j] > pivot) swap(A, i++, j--);
            if(A[i] >= pivot) i++;
            if(A[j] <= pivot) j--;
        }
        swap(A, L, j);
        return j;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}