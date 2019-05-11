import bst.BST;
import bst.BSTNode;
import heap.Heap;
import heap.HeapNode;
import heap.TreeHeap;
import org.junit.Test;

import static org.junit.Assert.*;

public class testPastFinal2012 {
    @Test
    public void testBSTMirror() throws Exception {
        BSTNode root = new BSTNode<>(3);
        BST<Integer> tree = new BST<Integer>(root, 5);
        root.left = new BSTNode<Integer>(5, null, null, root);
        root.left.left = new BSTNode<Integer>(4, null, null, root.left);
        root.right = new BSTNode<Integer>(1, null, null, root);
        root.right.left = new BSTNode<Integer>(2, null, null, root.right);
        BSTNode<Integer> mirrored = tree.createMirror();
        assertEquals(mirrored.data, (Integer) 3);
        assertEquals(mirrored.right.data, (Integer) 5);
        assertEquals(mirrored.right.right.data, (Integer) 4);
        assertEquals(mirrored.left.data, (Integer) 1);
        assertEquals(mirrored.left.right.data, (Integer) 2);
    }

    @Test
    public void testSortTwoArrays() throws Exception {
        int[] a1 = {8, 4, 7, 5, 2};
        int[] a2 = {6, 10, 3, 0, 11, 1};
        Algorithms.sortTwoArrays(a1, a2);
        final int[] r1 = {0, 1, 2, 3, 4};
        final int[] r2 = {5, 6, 7, 8, 10, 11};
        assertArrayEquals(a1, r1);
        assertArrayEquals(a2, r2);
    }

    @Test
    public void testHeapRemoveSecond() throws Exception {
        Heap heap1 = new Heap();
        heap1.add(4);
        heap1.add(3);
        heap1.add(2);
        heap1.add(1);
        heap1.add(7);
        heap1.removeSecond();
        assertEquals(heap1.pop(), 1);
        assertEquals(heap1.pop(), 3);
        assertEquals(heap1.pop(), 4);
        assertEquals(heap1.pop(), 7);
    }

    @Test
    public void testTreeHeapPop() throws Exception {
        TreeHeap h = new TreeHeap();
        h.root = new HeapNode();
        h.root.element = 1;
        h.root.left = new HeapNode();
        h.root.left.element = 2;
        h.root.left.parent = h.root;
        h.root.right = new HeapNode();
        h.root.right.element = 3;
        h.root.right.parent = h.root;
        h.root.left.left = new HeapNode();
        h.root.left.left.element = 4;
        h.root.left.left.parent = h.root.left;

        assertEquals(1, h.pop());
        assertTrue(isHeap(h.root));
    }

    public boolean isHeap(HeapNode h) {
        if (h == null) return true;
        if (h.left != null && h.left.element < h.element) return false;
        if (h.right != null && h.right.element < h.element) return false;
        return isHeap(h.left) && isHeap(h.right);
    }
}
