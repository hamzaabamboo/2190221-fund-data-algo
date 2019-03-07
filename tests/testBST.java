import bst.BST;
import bst.BSTNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testBST {

    public static BST<Integer> genBST() {
        BSTNode<Integer> root = new BSTNode<>(3);
        BST<Integer> tree = new BST<>(root, 1);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);

        return tree;
    }

    @Test
    public void testBSTHeight() throws Exception {
        BST<Integer> tree = genBST();
        assertEquals(3, tree.height());

        BST<Integer> tree2 = new BST<>(null, 1);
        tree2.insert(5);
        tree2.insert(4);
        tree2.insert(3);
        tree2.insert(2);
        tree2.insert(1);

        assertEquals(5, tree2.height());

    }

    @Test
    public void testBSTMirror() throws Exception {
        BST<Integer> tree = genBST();

        BSTNode mirror = tree.createMirror();
        assertEquals(1, mirror.right.data);
        assertEquals(2, mirror.right.left.data);
        assertEquals(4, mirror.left.data);
        assertEquals(5, mirror.left.left.data);

    }

    @Test
    public void testBSTGreaterThanTree() throws Exception {
        BST<Integer> tree = genBST();

        BST<Integer> res = tree.greaterThanTree(3);
        assertEquals((Integer) 4, res.root.data);
        assertEquals((Integer) 5, res.root.right.data);
    }

    @Test
    public void testBSTfindMax() {
        BST<Integer> tree = genBST();

        assertEquals((Integer) 5, tree.findMax());
    }

    @Test
    public void testBSTcombine() {
        BST<Integer> tree = genBST();

        BSTNode<Integer> root = new BSTNode<>(3);
        BST<Integer> tree2 = new BST<>(root, 1);
        tree2.insert(9);
        tree2.insert(5);
        tree2.insert(8);
        tree2.insert(7);

        tree.combine(tree2);

        assertEquals(8, tree.size);
    }

    @Test
    public void testCloneTree() throws Exception {
        BSTNode root = new BSTNode<>(3);
        BST<Integer> tree = new BST<Integer>(root, 10);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);

        BST<Integer> c = tree.cloneTree();
        assertEquals((Integer) 3, c.root.data);
        assertEquals((Integer) 5, c.root.right.right.data);
        assertEquals((Integer) 1, c.root.left.data);
        assertEquals((Integer) 2, c.root.left.right.data);
        assertEquals((Integer) 4, c.root.right.data);
    }
}
