import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ArrayListStackTest {

    @Test
    public void testArrayListStack() {
        ArrayListStack x = new ArrayListStack();
        ArrayList<Integer> a = x.getA();
        Assert.assertTrue(a.isEmpty());
    }

    @Test
    public void testIsEmpty() throws Exception {
        ArrayListStack x = new ArrayListStack();
        Assert.assertTrue(x.isEmpty());

        x.push(1);
        x.push(2);
        x.push(3);

        Assert.assertFalse(x.isEmpty());
        x.pop();
        Assert.assertFalse(x.isEmpty());
        x.pop();
        Assert.assertFalse(x.isEmpty());
        x.pop();
        Assert.assertTrue(x.isEmpty());

    }

    @Test
    public void testIsFull() throws Exception {
        ArrayListStack x = new ArrayListStack();
        Assert.assertFalse(x.isFull());

        for (int i = 0; i < 100000; i++) {
            x.push(i);
        }
        Assert.assertFalse(x.isFull());
    }

    @Test
    public void testMakeEmpty() throws Exception {
        ArrayListStack x = new ArrayListStack();

        for (int i = 0; i < 100000; i++) {
            x.push(i);
        }
        Assert.assertFalse(x.isEmpty());

        x.makeEmpty();
        Assert.assertTrue(x.isEmpty());

    }

    @Test
    public void testPushAndTop() throws Exception {
        ArrayListStack x = new ArrayListStack();

        x.push(1);
        Assert.assertEquals(1, x.top());
        x.push(2);
        Assert.assertEquals(2, x.top());
        x.push(3);
        Assert.assertEquals(3, x.top());

    }

    @Test
    public void testPopAndTop() throws Exception {
        ArrayListStack x = new ArrayListStack();

        x.push(1);
        x.push(2);
        x.push(3);

        Assert.assertEquals(3, x.top());
        x.pop();
        Assert.assertEquals(2, x.top());
        x.pop();
        Assert.assertEquals(1, x.top());

        x.push(5);
        x.push(6);
        Assert.assertEquals(6, x.top());
        x.pop();
        Assert.assertEquals(5, x.top());
        x.pop();
        Assert.assertEquals(1, x.top());
        x.pop();
        Assert.assertTrue(x.isEmpty());


    }

}
