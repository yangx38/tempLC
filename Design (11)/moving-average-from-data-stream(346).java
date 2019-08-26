// T = O(n) n as input integer length
// S = O(m) m as size

public class MovingAveragefromDataStream {
    Queue<Integer> queue;
    double sum = 0;
    int size;

    public MovingAveragefromDataStream(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if(queue.size() == size) {
            sum -= queue.remove();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}