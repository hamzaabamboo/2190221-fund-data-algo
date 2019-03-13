import org.junit.Test;

import static org.junit.Assert.*;

public class TestBSTRecursive {

    @Test
    public void testNumNodes() {
        BSTNode r = new BSTNode(7);
        BSTRecursive t = new BSTRecursive(r, 1);
        assertEquals(1, t.numNodes());
        t.insert(3);
        t.insert(1);
        t.insert(11);
        assertEquals(4, t.numNodes());
        t.insert(2);
        t.insert(5);
        t.insert(9);
        t.insert(6);
        assertEquals(8, t.numNodes());
        t.remove(5);
        t.remove(11);
        assertEquals(6, t.numNodes());
    }

    @Test
    public void testNumLeaves() {
        BSTNode r = new BSTNode(7);
        BSTRecursive t = new BSTRecursive(r, 1);
        assertEquals(1, t.numLeaves());
        t.insert(3);
        assertEquals(1, t.numLeaves());
        t.insert(1);
        assertEquals(1, t.numLeaves());
        t.insert(11);
        assertEquals(2, t.numLeaves());
        t.insert(2);
        assertEquals(2, t.numLeaves());
        t.insert(5);
        assertEquals(3, t.numLeaves());
        t.insert(9);
        t.insert(6);
        assertEquals(3, t.numLeaves());
        t.insert(0);
        t.insert(12);
        assertEquals(5, t.numLeaves());
        t.remove(7);
        assertEquals(4, t.numLeaves());
        t.remove(1);
        assertEquals(3, t.numLeaves());
        // BTreePrinter.printNode(t.root);
        // you can print out tree at each stage using this command
    }

    @Test
    public void testgreaterThan() {
        BSTRecursive t0 = new BSTRecursive(null, 0);
        assertTrue(t0.greaterThan(11).isEmpty());

        BSTNode r = new BSTNode(7);
        BSTRecursive t = new BSTRecursive(r, 1);
        t.insert(3);
        t.insert(11);
        t.insert(2);
        t.insert(5);
        t.insert(8);


        BSTRecursive x = t.greaterThan(3);
        assertEquals(4, x.size);
        assertTrue(x.find(7) != null);
        assertTrue(x.find(3) == null);
        assertTrue(x.find(11) != null);
        assertTrue(x.find(2) == null);
        assertTrue(x.find(5) != null);
        assertTrue(x.find(8) != null);


        x = t.greaterThan(5);
        assertEquals(3, x.size);
        assertTrue(x.find(7) != null);
        assertTrue(x.find(3) == null);
        assertTrue(x.find(11) != null);
        assertTrue(x.find(2) == null);
        assertTrue(x.find(5) == null);
        assertTrue(x.find(8) != null);

        x = t.greaterThan(7);
        assertEquals(2, x.size);
        assertTrue(x.find(7) == null);
        assertTrue(x.find(3) == null);
        assertTrue(x.find(11) != null);
        assertTrue(x.find(2) == null);
        assertTrue(x.find(5) == null);
        assertTrue(x.find(8) != null);


        BSTNode r2 = new BSTNode(8);
        BSTRecursive t2 = new BSTRecursive(r2, 1);
        t2.insert(4);
        t2.insert(19);
        t2.insert(3);
        t2.insert(6);
        t2.insert(11);
        t2.insert(20);
        t2.insert(15);
        t2.insert(10);
        t2.insert(9);

        x = t2.greaterThan(8);
        assertEquals(6, x.size);
        assertTrue(x.find(3) == null);
        assertTrue(x.find(4) == null);
        assertTrue(x.find(6) == null);
        assertTrue(x.find(8) == null);
        assertTrue(x.find(9) != null);
        assertTrue(x.find(10) != null);
        assertTrue(x.find(11) != null);
        assertTrue(x.find(15) != null);
        assertTrue(x.find(19) != null);
        assertTrue(x.find(20) != null);

        x = t2.greaterThan(10);
        assertEquals(4, x.size);
        assertTrue(x.find(3) == null);
        assertTrue(x.find(4) == null);
        assertTrue(x.find(6) == null);
        assertTrue(x.find(8) == null);
        assertTrue(x.find(9) == null);
        assertTrue(x.find(10) == null);
        assertTrue(x.find(11) != null);
        assertTrue(x.find(15) != null);
        assertTrue(x.find(19) != null);
        assertTrue(x.find(20) != null);

        x = t2.greaterThan(11);
        assertEquals(3, x.size);
        assertTrue(x.find(3) == null);
        assertTrue(x.find(4) == null);
        assertTrue(x.find(6) == null);
        assertTrue(x.find(8) == null);
        assertTrue(x.find(9) == null);
        assertTrue(x.find(10) == null);
        assertTrue(x.find(11) == null);
        assertTrue(x.find(15) != null);
        assertTrue(x.find(19) != null);
        assertTrue(x.find(20) != null);


    }


    @Test
    public void testtoStringInOrder() {
        BSTNode r = new BSTNode(7);
        BSTRecursive t = new BSTRecursive(r, 1);
        assertEquals("7", t.toStringInOrder());
        t.insert(3);
        t.insert(1);
        t.insert(11);
        assertEquals("1 3 7 11", t.toStringInOrder());
        t.insert(2);
        t.insert(5);
        t.insert(9);
        t.insert(6);
        assertEquals("1 2 3 5 6 7 9 11", t.toStringInOrder());
        t.remove(5);
        t.remove(11);
        assertEquals("1 2 3 6 7 9", t.toStringInOrder());
        t.remove(7);
        assertEquals("1 2 3 6 9", t.toStringInOrder());
        t.makeEmpty();
        assertEquals("", t.toStringInOrder());
    }

    @Test
    public void testisBST() {
        BSTNode r = new BSTNode(7);
        BSTRecursive t = new BSTRecursive(r, 1);
        assertTrue(t.isBST());
        t.insert(3);
        t.insert(1);
        t.insert(11);
        assertTrue(t.isBST());
        t.insert(2);
        t.insert(5);
        t.insert(9);
        t.insert(6);
        assertTrue(t.isBST());
        t.remove(5);
        t.remove(11);
        assertTrue(t.isBST());
        t.remove(7);
        assertTrue(t.isBST());
        t.makeEmpty();
        assertTrue(t.isBST());

        r = new BSTNode(7);
        t = new BSTRecursive(r, 1);
        t.insert(3);
        t.insert(9);
        BSTNode l1 = r.left;
        BSTNode r1 = r.right;

        BSTNode ll1 = new BSTNode(4, null, null, l1);
        l1.left = ll1;
        assertFalse(t.isBST());

        l1.left = null;
        BSTNode ll2 = new BSTNode(8, null, null, l1);
        l1.right = ll2;
        assertFalse(t.isBST());

        l1.right = null;
        BSTNode rr1 = new BSTNode(5, null, null, r1);
        r1.left = rr1;
        assertFalse(t.isBST());

        r1.left = null;
        BSTNode rr2 = new BSTNode(8, null, null, r1);
        r1.right = rr2;
        assertFalse(t.isBST());
    }

    @Test
    public void testFindParentForwardDirection() {
        BSTNode r = new BSTNode(7);
        BSTRecursive t = new BSTRecursive(r, 1);
        t.insert(3);
        t.insert(1);
        t.insert(11);
        t.insert(2);
        t.insert(5);
        t.insert(9);
        t.insert(6);
        BSTNode n1 = t.root.left.left.right;
        BSTNode n2 = t.root.left.right.right;
        BSTNode n3 = t.root.left.left;
        BSTNode n4 = t.root.left.right;
        BSTNode n5 = t.root.right.left;
        BSTNode n6 = t.root.left;
        BSTNode n7 = t.root.right;

        assertEquals(n3, t.findParentForwardDirection(n1));
        assertEquals(n4, t.findParentForwardDirection(n2));
        assertEquals(n6, t.findParentForwardDirection(n3));
        assertEquals(n6, t.findParentForwardDirection(n4));
        assertEquals(n7, t.findParentForwardDirection(n5));
        assertEquals(t.root, t.findParentForwardDirection(n6));
        assertEquals(t.root, t.findParentForwardDirection(n7));
        assertEquals(null, t.findParentForwardDirection(t.root));

    }

}
