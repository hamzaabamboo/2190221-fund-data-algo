package test;

import org.junit.Test;
import practice.linkedlist.CDLinkedList;
import practice.queue.TestQueue;
import practice.stack.TestStack;

import java.util.ArrayDeque;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

// The other two questions asks about Implementing Stack with Queue, Implementing BST that has Duplicates, and Implement removeAt
public class testMidterm2018 {
    @Test
    public void testQueueCombine() { // Midterm Q3
        ArrayDeque<Integer> queue = testQueue.genQueue();
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

    @Test
    public void testStackInsertAtBottom() throws Exception {
        TestStack<Integer> stack = new TestStack<Integer>();
        stack.s = new Stack<>();
        stack.s.push(1);
        stack.s.push(4);
        stack.s.push(3);
        stack.s.push(5);
        stack.s.push(6);

        stack.insertAtBottom(10, 2);
        stack.insertAtBottom(3, 9);

        assertEquals((Integer) 2, stack.s.pop());
        assertEquals((Integer) 6, stack.s.pop());
        assertEquals((Integer) 5, stack.s.pop());
        assertEquals((Integer) 9, stack.s.pop());
        assertEquals((Integer) 3, stack.s.pop());
        assertEquals((Integer) 4, stack.s.pop());
        assertEquals((Integer) 1, stack.s.pop());
    }

    @Test
    public void testCDLinkedListSortOLogN() throws Exception {
        CDLinkedList<Integer> cd = testLinkedList.genList();

        CDLinkedList<Integer> sorted = CDLinkedList.sortONLogN(cd);
        assertEquals((Integer) 3, sorted.header.nextNode.data);
        assertEquals((Integer) 4, sorted.header.nextNode.nextNode.data);
        assertEquals((Integer) 6, sorted.header.nextNode.nextNode.nextNode.data);
        assertEquals((Integer) 7, sorted.header.nextNode.nextNode.nextNode.nextNode.data);
    }

}
