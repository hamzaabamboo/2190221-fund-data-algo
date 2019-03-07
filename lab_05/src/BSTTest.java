import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

public class BSTTest {

    @Test
    public void testHasGreaterValueThan() {
        BST t0 = new BST();
        Assert.assertFalse(t0.hasGreaterValueThan(11));

        BSTNode r = new BSTNode(7);
        BST t = new BST(r, 1);
        t.insert(3);
        t.insert(11);
        t.insert(2);
        t.insert(5);
        t.insert(8);

        Assert.assertTrue(t.hasGreaterValueThan(1));
        Assert.assertTrue(t.hasGreaterValueThan(3));
        Assert.assertTrue(t.hasGreaterValueThan(5));
        Assert.assertTrue(t.hasGreaterValueThan(8));
        Assert.assertFalse(t.hasGreaterValueThan(11));


        BSTNode r2 = new BSTNode(8);
        BST t2 = new BST(r2, 1);
        t2.insert(4);
        t2.insert(19);
        t2.insert(3);
        t2.insert(6);
        t2.insert(11);
        t2.insert(20);
        t2.insert(15);
        t2.insert(10);
        t2.insert(9);

        Assert.assertTrue(t2.hasGreaterValueThan(3));
        Assert.assertTrue(t2.hasGreaterValueThan(4));
        Assert.assertTrue(t2.hasGreaterValueThan(6));
        Assert.assertTrue(t2.hasGreaterValueThan(8));
        Assert.assertTrue(t2.hasGreaterValueThan(19));
        Assert.assertTrue(t2.hasGreaterValueThan(11));
        Assert.assertTrue(t2.hasGreaterValueThan(10));
        Assert.assertTrue(t2.hasGreaterValueThan(15));
        Assert.assertTrue(t2.hasGreaterValueThan(9));
        Assert.assertFalse(t2.hasGreaterValueThan(20));
        Assert.assertFalse(t2.hasGreaterValueThan(21));


    }

    @Test
    public void testDifference() throws Exception {
        BST t0 = new BST();
        Assert.assertFalse(t0.hasGreaterValueThan(11));

        BSTNode r = new BSTNode(7);
        BST t = new BST(r, 1);
        t.insert(3);
        t.insert(11);
        t.insert(2);
        t.insert(5);
        t.insert(8);

        BST result1 = t0.difference(t);
        Assert.assertTrue(result1.isEmpty());

        BST result2 = t.difference(t0);
        assertEquals(6, result2.size);
        Assert.assertNotNull(result2.find(7));
        Assert.assertNotNull(result2.find(3));
        Assert.assertNotNull(result2.find(11));
        Assert.assertNotNull(result2.find(2));
        Assert.assertNotNull(result2.find(5));
        Assert.assertNotNull(result2.find(8));

        TreeIterator itr = result2.findMin(result2.root);
        int currentData = itr.currentNode.data;
        Assert.assertEquals(2, currentData);
        currentData = itr.next();
        Assert.assertEquals(3, currentData);
        currentData = itr.next();
        Assert.assertEquals(5, currentData);
        currentData = itr.next();
        Assert.assertEquals(7, currentData);
        currentData = itr.next();
        Assert.assertEquals(8, currentData);
        currentData = itr.next();
        Assert.assertEquals(11, currentData);

        BSTNode r2 = new BSTNode(8);
        BST t2 = new BST(r2, 1);
        t2.insert(4);
        t2.insert(19);
        t2.insert(3);
        t2.insert(6);
        t2.insert(11);
        t2.insert(20);
        t2.insert(15);
        t2.insert(10);
        t2.insert(9);

        BST result3 = t.difference(t2);
        assertEquals(3, result3.size);
        itr = result3.findMin(result3.root);
        currentData = itr.currentNode.data;
        Assert.assertEquals(2, currentData);
        currentData = itr.next();
        Assert.assertEquals(5, currentData);
        currentData = itr.next();
        Assert.assertEquals(7, currentData);

        BST result4 = t2.difference(t);
        assertEquals(7, result4.size);
        itr = result4.findMin(result4.root);
        currentData = itr.currentNode.data;
        Assert.assertEquals(4, currentData);
        currentData = itr.next();
        Assert.assertEquals(6, currentData);
        currentData = itr.next();
        Assert.assertEquals(9, currentData);
        currentData = itr.next();
        Assert.assertEquals(10, currentData);
        currentData = itr.next();
        Assert.assertEquals(15, currentData);
        currentData = itr.next();
        Assert.assertEquals(19, currentData);
        currentData = itr.next();
        Assert.assertEquals(20, currentData);

    }

}
