import org.junit.Test;
import stack.TestStack;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class testStack {
    @Test
    public void testStackPutIn() throws Exception {
        TestStack<Integer> stack = new TestStack<>();
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
}
