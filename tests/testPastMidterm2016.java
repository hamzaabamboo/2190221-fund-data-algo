import bst.BST;
import bst.BSTNode;
import linkedlist.CDLinkedList;
import linkedlist.DListIterator;
import org.junit.Test;
import queue.TestQueue;
import stack.TestStack;

import java.util.ArrayDeque;
import java.util.Stack;

import static org.junit.Assert.*;

public class testPastMidterm2016 {

    @Test
    public void testBSTfix() throws Exception {
        BSTNode root = new BSTNode<>(3);
        BST<Integer> tree = new BST<Integer>(root, 5);
        root.left = new BSTNode<Integer>(5, null, null, root);
        root.left.left = new BSTNode<Integer>(4, null, null, root.left);
        root.right = new BSTNode<Integer>(1, null, null, root);
        root.right.left = new BSTNode<Integer>(2, null, null, root.right);
        assertFalse(isBST(root));
        BST<Integer> fixed = tree.fixTree();
        assertTrue(isBST(fixed.root));
        assertEquals(tree.size, fixed.size);
    }

    @Test
    public void testStackOddNumbers() throws Exception {
        TestStack<Integer> stack = new TestStack<>();
        stack.s = new Stack<>();
        stack.s.push(6);
        stack.s.push(5);
        stack.s.push(3);
        stack.s.push(4);
        stack.s.push(1);
        Stack res = stack.oddNumbers();

        assertEquals(3, res.size());
        assertEquals(1, res.pop());
        assertEquals(3, res.pop());
        assertEquals(5, res.pop());
    }

    private static <T extends Comparable> boolean isBST(BSTNode<T> node) {
        if (node == null) return true;
        if (node.left != null)
            if (node.left.data.compareTo(node.data) > 0) return false;
        if (node.right != null)
            if (node.right.data.compareTo(node.data) < 0) return false;
        return (isBST(node.left) && isBST(node.right));
    }

    @Test
    public void testQueueCrossOver() throws Exception {
        TestQueue<Integer> queue = new TestQueue<>();
        queue.q = new ArrayDeque<>();
        queue.q2 = new ArrayDeque<>();
        queue.q.addFirst(1);
        queue.q.addLast(2);
        queue.q.addLast(3);
        queue.q.addLast(4);
        queue.q.addLast(5);
        queue.q2.addFirst(6);
        queue.q2.addLast(7);
        queue.q2.addLast(8);
        queue.q2.addLast(9);
        queue.q2.addLast(10);
        queue.crossOver(2, 3);
        assertEquals((Integer) 1, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 2, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 9, queue.q.peek());
        queue.cycle(1, queue.q);
        assertEquals((Integer) 10, queue.q.peek());
        queue.cycle(1, queue.q);

        assertEquals((Integer) 6, queue.q2.peek());
        queue.cycle(1, queue.q2);
        assertEquals((Integer) 7, queue.q2.peek());
        queue.cycle(1, queue.q2);
        assertEquals((Integer) 8, queue.q2.peek());
        queue.cycle(1, queue.q2);
        assertEquals((Integer) 3, queue.q2.peek());
        queue.cycle(1, queue.q2);
        assertEquals((Integer) 4, queue.q2.peek());
        queue.cycle(1, queue.q2);
        assertEquals((Integer) 5, queue.q2.peek());
        queue.cycle(1, queue.q2);
    }

    @Test
    public void testCDLinkedListSwap() throws Exception {
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
        cd.swap(7, 6);

        assertEquals((Integer) 3, cd.header.nextNode.data);
        assertEquals((Integer) 7, cd.header.nextNode.nextNode.data);
        assertEquals((Integer) 4, cd.header.nextNode.nextNode.nextNode.data);
        assertEquals((Integer) 6, cd.header.nextNode.nextNode.nextNode.nextNode.data);
    }
}
