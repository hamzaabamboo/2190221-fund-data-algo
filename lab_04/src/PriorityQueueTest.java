import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {

    @Test
    public void testPushAndTop() throws Exception {

        // test with generic queue
        MyQueue q = new QueueArray();
        PriorityQueue p = new PriorityQueue(q);

        p.push(2);
        p.push(8);
        Assert.assertEquals(2, p.top());

        p.push(6);
        p.push(7);
        p.push(3);
        Assert.assertEquals(2, p.top());

        p.push(1);
        Assert.assertEquals(1, p.top());

        // now test with another queue with duplicated data
        q = new QueueArray();
        p = new PriorityQueue(q);
        p.push(3);
        Assert.assertEquals(3, p.top());
        p.push(7);
        Assert.assertEquals(3, p.top());
        p.push(1);
        Assert.assertEquals(1, p.top());
        p.push(5);
        Assert.assertEquals(1, p.top());
        p.push(2);
        Assert.assertEquals(1, p.top());
        p.push(4);
        Assert.assertEquals(1, p.top());
        p.push(1);
        Assert.assertEquals(1, p.top());
        p.push(5);
        Assert.assertEquals(1, p.top());

    }

    @Test
    public void testPopAndTop() throws Exception {
        // test with generic queue
        MyQueue q = new QueueArray();
        PriorityQueue p = new PriorityQueue(q);

        p.push(2);
        p.push(8);
        p.push(6);
        p.push(7);
        p.push(3);
        p.push(1);
        Assert.assertEquals(1, p.top());
        p.pop();
        Assert.assertEquals(2, p.top());
        p.pop();
        Assert.assertEquals(3, p.top());
        p.pop();
        Assert.assertEquals(6, p.top());
        p.pop();
        Assert.assertEquals(7, p.top());
        p.pop();
        Assert.assertEquals(8, p.top());
        p.pop();
        Assert.assertTrue(p.q.isEmpty());

        // now test with another queue with duplicated data
        q = new QueueArray();
        p = new PriorityQueue(q);
        p.push(3);
        p.push(7);
        p.push(1);
        p.push(5);
        p.push(2);
        p.push(4);
        p.push(1);
        p.push(5);
        Assert.assertEquals(1, p.top());
        p.pop();
        Assert.assertEquals(1, p.top());
        p.pop();
        Assert.assertEquals(2, p.top());
        p.pop();
        Assert.assertEquals(3, p.top());
        p.push(2);
        Assert.assertEquals(2, p.top());
        p.push(6);
        Assert.assertEquals(2, p.top());
        p.pop();
        Assert.assertEquals(3, p.top());
        p.pop();
        Assert.assertEquals(4, p.top());
        p.pop();
        Assert.assertEquals(5, p.top());
        p.pop();
        Assert.assertEquals(5, p.top());
        p.pop();
        Assert.assertEquals(6, p.top());
        p.pop();
        Assert.assertEquals(7, p.top());
    }

}
