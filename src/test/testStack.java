package test;

import org.junit.Test;
import stack.TestStack;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class testStack {
    @Test
    public void testStackOddNumbers() throws Exception {
        TestStack<Integer> stack = new TestStack<Integer>();
        stack.s = new Stack<>();
        stack.s.push(1);
        stack.s.push(4);
        stack.s.push(3);
        stack.s.push(5);
        stack.s.push(6);
        stack.removeMin();
        assertEquals(4, stack.s.size());
        assertEquals((Integer) 6, stack.s.pop());
        assertEquals((Integer) 5, stack.s.pop());
        assertEquals((Integer) 3, stack.s.pop());
        assertEquals((Integer) 4, stack.s.pop());

    }

    @Test
    public void testStackPutIn() throws Exception {
        TestStack<Integer> stack = new TestStack<Integer>();
        stack.s = new Stack<>();
        stack.putIn(1);
        stack.putIn(4);
        stack.putIn(3);
        stack.putIn(5);
        stack.putIn(6);

        assertEquals((Integer) 6, stack.s.pop());
        assertEquals((Integer) 5, stack.s.pop());
        assertEquals((Integer) 4, stack.s.pop());
        assertEquals((Integer) 3, stack.s.pop());
        assertEquals((Integer) 1, stack.s.pop());
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
}
