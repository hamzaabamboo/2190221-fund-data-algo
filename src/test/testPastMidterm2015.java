package test;

import org.junit.Test;
import practice.bst.BST;
import practice.bst.BSTNode;
import practice.linkedlist.CDLinkedList;
import practice.linkedlist.DListIterator;
import practice.queue.TestQueue;
import practice.stack.TestStack;

import java.util.ArrayDeque;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class testPastMidterm2015 {

    @Test
    public void testBSTInsert() throws Exception {
        BSTNode root = new BSTNode<>(3);
        BST<Integer> tree = new BST<Integer>(root, 10);
        tree.insert(1);
        assertEquals((Integer) 1, tree.root.left.data);
        tree.insert(2);
        assertEquals((Integer) 2, tree.root.left.right.data);
        tree.insert(4);
        assertEquals((Integer) 4, tree.root.right.data);
        tree.insert(5);
        assertEquals((Integer) 5, tree.root.right.right.data);
    }

    @Test
    public void testStackRemoveDup() throws Exception {
        TestStack<Integer> stack = new TestStack<Integer>();
        stack.s = new Stack<Integer>();
        stack.s.push(1);
        stack.s.push(4);
        stack.s.push(3);
        stack.s.push(1);
        stack.s.push(3);
        stack.removeDup();

        assertEquals(3, stack.s.size());
    }

    @Test
    public void testQueueSwap() throws Exception {
        TestQueue<Integer> queue = new TestQueue<Integer>();
        queue.q = new ArrayDeque<>();
        queue.q.addFirst(1);
        queue.q.addLast(2);
        queue.q.addLast(3);
        queue.q.addLast(4);
        queue.q.addLast(5);
        queue.swap(1, 3);
        assertEquals((Integer) 1, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 4, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 3, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 2, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 5, queue.q.peek());
        queue.cycle(1, queue.q);

        queue.swap(3, 1);
        assertEquals((Integer) 1, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 2, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 3, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 4, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 5, queue.q.peek());
        queue.cycle(1, queue.q);
    }

    @Test
    public void testCDLinkedListPartition() throws Exception {
        CDLinkedList<Integer> cd = new CDLinkedList<>();
        DListIterator<Integer> itr = new DListIterator<>(cd.header);

        cd.insert(3, itr);
        itr.next();
        cd.insert(6, itr);
        itr.next();
        cd.insert(4, itr);
        itr.next();
        cd.insert(7, itr);
        itr.next();
        CDLinkedList<Integer> res = cd.partition(5);

        assertEquals((Integer) 3, cd.header.nextNode.data);
        assertEquals((Integer) 4, cd.header.nextNode.nextNode.data);
        assertEquals((Integer) 6, res.header.nextNode.data);
        assertEquals((Integer) 7, res.header.nextNode.nextNode.data);
    }
}