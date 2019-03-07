import linkedlist.CDLinkedList;
import linkedlist.DListIterator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testLinkedList {

    public static CDLinkedList<Integer> genList() throws Exception {
        CDLinkedList<Integer> cd = new CDLinkedList<>();
        DListIterator<Integer> itr = new DListIterator<>(cd.header);

        cd.insert(3, itr);
        itr.next();
        cd.insert(6, itr);
        itr.next();
        cd.insert(4, itr);
        itr.next();
        cd.insert(7, itr);
        itr.next()
        ;
        return cd;
    }

    @Test
    public void testCDLinkedListInsertFront() throws Exception {
        CDLinkedList<Integer> cd = genList();

        cd.insertAtFront(5);
        assertEquals((Integer) 5, cd.header.nextNode.data);
        assertEquals((Integer) 3, cd.header.nextNode.nextNode.data);
        assertEquals((Integer) 6, cd.header.nextNode.nextNode.nextNode.data);
        assertEquals((Integer) 4, cd.header.nextNode.nextNode.nextNode.nextNode.data);
        assertEquals((Integer) 7, cd.header.nextNode.nextNode.nextNode.nextNode.nextNode.data);
    }

    @Test
    public void testCDLinkedListRemoveLast() throws Exception {
        CDLinkedList<Integer> cd = genList();

        int v = cd.removeAtLast();
        assertEquals(7, v);
        assertEquals((Integer) 3, cd.header.nextNode.data);
        assertEquals((Integer) 6, cd.header.nextNode.nextNode.data);
        assertEquals((Integer) 4, cd.header.nextNode.nextNode.nextNode.data);
        assertEquals((Integer) 3, cd.header.nextNode.nextNode.nextNode.nextNode.nextNode.data);
    }

    @Test
    public void testCDLinkedListReverse() throws Exception {
        CDLinkedList<Integer> cd = genList();

        cd.reverseList();
        assertEquals((Integer) 7, cd.header.nextNode.data);
        assertEquals((Integer) 4, cd.header.nextNode.nextNode.data);
        assertEquals((Integer) 6, cd.header.nextNode.nextNode.nextNode.data);
        assertEquals((Integer) 3, cd.header.nextNode.nextNode.nextNode.nextNode.data);
    }

    @Test
    public void testCDLinkedListIsInFront() throws Exception {
        CDLinkedList<Integer> cd = genList();

        assertTrue(cd.isInFront(3, 4));
        assertTrue(!cd.isInFront(7, 6));
    }

}
