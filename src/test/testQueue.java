package test;

import org.junit.Test;
import queue.TestQueue;

import java.util.ArrayDeque;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testQueueCombine() { // Midterm Q3
        ArrayDeque<Integer> queue = genQueue();
        ArrayDeque<Integer> queue2 = new ArrayDeque<>();
        queue2.addFirst(0);
        queue2.addLast(2);
        queue2.addLast(4);
        queue2.addLast(6);
        queue2.addLast(8);

        ArrayDeque<Integer> res = TestQueue.combine(queue, queue2);

        assertEquals(10, res.size());
        assertEquals((Integer) 0, res.removeFirst());
        assertEquals((Integer) 1, res.removeFirst());
        assertEquals((Integer) 2, res.removeFirst());
        assertEquals((Integer) 3, res.removeFirst());
        assertEquals((Integer) 4, res.removeFirst());
        assertEquals((Integer) 5, res.removeFirst());
        assertEquals((Integer) 6, res.removeFirst());
        assertEquals((Integer) 7, res.removeFirst());
        assertEquals((Integer) 8, res.removeFirst());
        assertEquals((Integer) 9, res.removeFirst());
    }
}
