package lab.lab_4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueueArrayTest {

    @Test
    public void testReverse() throws Exception {
        QueueArray q = new QueueArray();
        q.reverse();
        assertTrue(q.isEmpty());

        for (int i = 1; i <= 10; i++) {
            q.insertLast(i);
        }
        for (int i = 1; i <= 5; i++) {
            q.removeFirst();
        }
        for (int i = 11; i <= 13; i++) {
            q.insertLast(i);
        }

        q.reverse();

        for (int i = 13; i >= 6; i--) {
            assertEquals(i, q.removeFirst());
        }

    }

}
