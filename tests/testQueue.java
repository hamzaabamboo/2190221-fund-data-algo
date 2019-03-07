import java.util.ArrayDeque;

public class testQueue {
    public static ArrayDeque<Integer> genQueue() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addFirst(1);
        queue.addLast(3);
        queue.addLast(5);
        queue.addLast(7);
        queue.addLast(9);
        return queue;
    }
}
