import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AVLTreeTest {

    @Test
    public void testMakeAVL() throws Exception {
        AVLTree t = new AVLTree();
        t.root = t.insertNoBalance(100);
        t.root = t.insertNoBalance(50);
        t.root = t.insertNoBalance(30);
        t.root = t.insertNoBalance(40);
        t.root = t.insertNoBalance(35);
        t.root = t.insertNoBalance(32);

        t.root = t.insertNoBalance(200);
        t.root = t.insertNoBalance(150);
        t.root = t.insertNoBalance(175);
        t.root = t.insertNoBalance(190);
        t.root = t.insertNoBalance(160);
        t.root = t.insertNoBalance(155);
        t.root = t.insertNoBalance(170);
        t.root = t.insertNoBalance(172);
        t.root = t.insertNoBalance(174);
        t.root = t.insertNoBalance(165);
        t.root = t.insertNoBalance(163);
        t.root = t.insertNoBalance(164);
        assertFalse(t.isAVL());
        // BTreePrinter.printNode(t.root);

        t.makeAVL();
        assertTrue(t.isAVL());
        // BTreePrinter.printNode(t.root);

    }

    @Test
    public void testIsAVL() {
        AVLTree t = new AVLTree();
        // an empty tree is AVL
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(7);
        t.root = t.insertNoBalance(2);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(12);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(20);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(14);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(9);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(30);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(-5);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(-10);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(4);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(-8);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(-1);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(1);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(3);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(0);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(5);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(6);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(16);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(8);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(-3);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(10);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(11);
        assertTrue(t.isAVL());

        t.root = t.insertNoBalance(18);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(40);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(15);
        assertFalse(t.isAVL());

        t.root = t.insertNoBalance(13);
        assertTrue(t.isAVL());

    }

    @Test
    public void testSame() {

        AVLTree t1 = new AVLTree();
        AVLTree t2 = new AVLTree();
        assertTrue(AVLTree.same(t1, t2));

        t1.root = t1.insertNoBalance(5);
        t1.root = t1.insertNoBalance(2);
        t1.root = t1.insertNoBalance(1);
        t1.root = t1.insertNoBalance(3);
        t1.root = t1.insertNoBalance(4);
        t1.root = t1.insertNoBalance(7);
        t1.root = t1.insertNoBalance(6);
        t2.root = t2.insertNoBalance(5);
        t2.root = t2.insertNoBalance(7);
        t2.root = t2.insertNoBalance(6);
        t2.root = t2.insertNoBalance(2);
        t2.root = t2.insertNoBalance(3);
        t2.root = t2.insertNoBalance(4);
        t2.root = t2.insertNoBalance(1);
        assertTrue(AVLTree.same(t1, t2));

        t1 = new AVLTree();
        t2 = new AVLTree();
        t1.root = t1.insertNoBalance(4);
        t1.root = t1.insertNoBalance(2);
        t1.root = t1.insertNoBalance(6);
        t1.root = t1.insertNoBalance(1);
        t1.root = t1.insertNoBalance(3);
        t1.root = t1.insertNoBalance(5);
        t2.root = t2.insertNoBalance(4);
        t2.root = t2.insertNoBalance(2);
        t2.root = t2.insertNoBalance(5);
        t2.root = t2.insertNoBalance(1);
        t2.root = t2.insertNoBalance(3);
        t2.root = t2.insertNoBalance(6);
        assertFalse(AVLTree.same(t1, t2));
        t2.root = t2.remove(5);
        t2.root = t2.insert(5);
        assertTrue(AVLTree.same(t1, t2));

        t1 = new AVLTree();
        t2 = new AVLTree();
        t1.root = t1.insertNoBalance(6);
        t1.root = t1.insertNoBalance(2);
        t1.root = t1.insertNoBalance(7);
        t1.root = t1.insertNoBalance(1);
        t1.root = t1.insertNoBalance(5);
        t1.root = t1.insertNoBalance(3);

        t2.root = t2.insertNoBalance(6);
        t2.root = t2.insertNoBalance(2);
        t2.root = t2.insertNoBalance(7);
        t2.root = t2.insertNoBalance(1);
        t2.root = t2.insertNoBalance(5);
        t2.root = t2.insertNoBalance(4);
        assertFalse(AVLTree.same(t1, t2));

        t2.root = t2.remove(4);
        t2.root = t2.insertNoBalance(3);
        //BTreePrinter.printNode(t1.root);
        //BTreePrinter.printNode(t2.root);

        assertTrue(AVLTree.same(t1, t2));
    }

}
