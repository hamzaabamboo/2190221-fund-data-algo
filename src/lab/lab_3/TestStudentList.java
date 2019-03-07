package lab.lab_3;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestStudentList {

    @Test
    public void testRemoveStudent() throws Exception {
        Student a = new Student("1", "a", "female");
        Student b = new Student("2", "b", "male");
        Student c = new Student("3", "c", "female");
        Student d = new Student("4", "d", "male" +
                "");
        Student e = new Student("5", "e", "female");

        StudentList ss = new StudentList();
        DListIterator itr = new DListIterator(ss.header);
        ss.insert(a, itr);
        itr.next();
        ss.insert(b, itr);
        itr.next();
        ss.insert(c, itr);
        itr.next();
        ss.insert(d, itr);
        itr.next();
        ss.insert(e, itr);
        itr.next();

        Student data = (Student) ss.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) ss.findKth(1);
        assertEquals("2", data.getId());
        data = (Student) ss.findKth(2);
        assertEquals("3", data.getId());
        data = (Student) ss.findKth(3);
        assertEquals("4", data.getId());
        data = (Student) ss.findKth(4);
        assertEquals("5", data.getId());

        ss.removeStudent("1");
        data = (Student) ss.findKth(0);
        assertEquals("2", data.getId());
        data = (Student) ss.findKth(1);
        assertEquals("3", data.getId());
        data = (Student) ss.findKth(2);
        assertEquals("4", data.getId());
        data = (Student) ss.findKth(3);
        assertEquals("5", data.getId());

        ss.removeStudent("4");
        data = (Student) ss.findKth(0);
        assertEquals("2", data.getId());
        data = (Student) ss.findKth(1);
        assertEquals("3", data.getId());
        data = (Student) ss.findKth(2);
        assertEquals("5", data.getId());

        ss.removeStudent("4");
        data = (Student) ss.findKth(0);
        assertEquals("2", data.getId());
        data = (Student) ss.findKth(1);
        assertEquals("3", data.getId());
        data = (Student) ss.findKth(2);
        assertEquals("5", data.getId());

        ss.removeStudent("5");
        data = (Student) ss.findKth(0);
        assertEquals("2", data.getId());
        data = (Student) ss.findKth(1);
        assertEquals("3", data.getId());

        ss.removeStudent("2");
        data = (Student) ss.findKth(0);
        assertEquals("3", data.getId());

        ss.removeStudent("2");
        data = (Student) ss.findKth(0);
        assertEquals("3", data.getId());

        ss.removeStudent("3");
        assertTrue(ss.isEmpty());

    }

    @Test
    public void testAppendQuick() throws Exception {
        Student a = new Student("1", "a", "female");
        Student b = new Student("2", "b", "male");
        Student c = new Student("3", "c", "female");
        Student d = new Student("4", "d", "male");
        Student e = new Student("5", "e", "female");

        // empty list appends with another list
        //
        StudentList s1 = new StudentList();
        StudentList s2 = new StudentList();

        DListIterator itr = new DListIterator(s2.header);
        s2.insert(a, itr);
        itr.next();
        s2.insert(b, itr);
        itr.next();

        s1.appendQuick(s2); // content must change
        Student data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());
        assertEquals(2, s1.size());

        // must be able to iterate back from the end of the list
        DListIterator ir = new DListIterator(s1.header);
        ir.previous();
        Student s = (Student) ir.previous();
        assertEquals("2", s.getId());
        s = (Student) ir.previous();
        assertEquals("a", s.getName());

        // change from s2 affects s1
        Student firstData = (Student) (s2.header.nextNode.data);
        firstData.setName("Kira");
        data = (Student) s1.findKth(0);
        assertEquals("Kira", data.getName());

        //
        // generic lists appends to one another
        //
        s1 = new StudentList();
        s2 = new StudentList();

        DListIterator itr1 = new DListIterator(s1.header);
        s1.insert(a, itr1);
        itr1.next();
        s1.insert(b, itr1);
        itr1.next();

        DListIterator itr2 = new DListIterator(s2.header);
        s2.insert(c, itr2);
        itr2.next();
        s2.insert(d, itr2);
        itr2.next();
        s2.insert(e, itr2);
        itr2.next();

        s1.appendQuick(s2); // list appends correctly
        data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());
        data = (Student) s1.findKth(2);
        assertEquals("3", data.getId());
        data = (Student) s1.findKth(3);
        assertEquals("4", data.getId());
        data = (Student) s1.findKth(4);
        assertEquals("5", data.getId());

        // must be able to iterate back from the end of the list
        DListIterator ir2 = new DListIterator(s1.header.previousNode);
        int count = 5;
        while (count > 0) {
            assertEquals(String.valueOf(count), ((Student) ir2.currentNode.data).getId());
            ir2.previous();
            count--;
        }
        assertEquals(5, s1.size());

        // changes from s2 affects s1
        DListIterator itrX = new DListIterator(s2.header.nextNode.nextNode);
        s2.removeAt(itrX);
        data = (Student) s2.findKth(0);
        assertEquals("3", data.getId());
        data = (Student) s2.findKth(1);
        assertEquals("5", data.getId());

        data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());
        data = (Student) s1.findKth(2);
        assertEquals("3", data.getId());
        data = (Student) s1.findKth(3);
        assertEquals("5", data.getId());

        //
        // generic list appends to empty list
        //
        s1 = new StudentList();
        s2 = new StudentList();

        itr1 = new DListIterator(s1.header);
        s1.insert(a, itr1);
        itr1.next();
        s1.insert(b, itr1);
        itr1.next();

        s1.appendQuick(s2);
        data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());

        // must be able to iterate back from the end of the list
        ir = new DListIterator(s1.header);
        ir.previous();
        s = (Student) ir.previous();
        assertNotNull(s);
        assertEquals("2", s.getId());
        s = (Student) ir.previous();
        assertEquals("1", s.getId());

        // changes to s2 does not affect s1 in this case
        s2.insert(c, new DListIterator(s2.header));

        data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());
        assertEquals(2, s1.size());

    }

    @Test
    public void testAppend() throws Exception {
        Student a = new Student("1", "a", "female");
        Student b = new Student("2", "b", "male");
        Student c = new Student("3", "c", "female");
        Student d = new Student("4", "d", "male");
        Student e = new Student("5", "e", "female");

        // empty list appends with another list
        //
        StudentList s1 = new StudentList();
        StudentList s2 = new StudentList();

        DListIterator itr = new DListIterator(s2.header);
        s2.insert(a, itr);
        itr.next();
        s2.insert(b, itr);
        itr.next();

        s1.append(s2); // content must change
        Student data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());
        assertEquals(2, s1.size());

        // must be able to iterate back from the end of the list
        DListIterator ir = new DListIterator(s1.header);
        ir.previous();
        Student s = (Student) ir.previous();
        assertEquals("2", s.getId());
        s = (Student) ir.previous();
        assertEquals("1", s.getId());

        // change from s2 DOES NOT AFFECT s1
        Student firstData = (Student) (s2.header.nextNode.data);
        firstData.setName("Kira");
        data = (Student) s1.findKth(0);
        assertEquals("a", data.getName());

        //
        // generic lists appends to one another
        //
        s1 = new StudentList();
        s2 = new StudentList();

        DListIterator itr1 = new DListIterator(s1.header);
        s1.insert(a, itr1);
        itr1.next();
        s1.insert(b, itr1);
        itr1.next();

        DListIterator itr2 = new DListIterator(s2.header);
        s2.insert(c, itr2);
        itr2.next();
        s2.insert(d, itr2);
        itr2.next();
        s2.insert(e, itr2);
        itr2.next();

        s1.append(s2); // list appends correctly
        data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());
        data = (Student) s1.findKth(2);
        assertEquals("3", data.getId());
        data = (Student) s1.findKth(3);
        assertEquals("4", data.getId());
        data = (Student) s1.findKth(4);
        assertEquals("5", data.getId());
        assertEquals(5, s1.size());

        // must be able to iterate back from the end of the list
        DListIterator ir2 = new DListIterator(s1.header.previousNode);
        int count = 5;
        while (count > 0) {
            assertEquals(String.valueOf(count), ((Student) ir2.currentNode.data).getId());
            ir2.previous();
            count--;
        }

        // changes from s2 DOES NOT AFFECT s1
        DListIterator itrX = new DListIterator(s2.header.nextNode.nextNode);
        s2.removeAt(itrX);
        data = (Student) s2.findKth(0);
        assertEquals("3", data.getId());
        data = (Student) s2.findKth(1);
        assertEquals("5", data.getId());

        data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());
        data = (Student) s1.findKth(2);
        assertEquals("3", data.getId());
        data = (Student) s1.findKth(3);
        assertEquals("4", data.getId());
        data = (Student) s1.findKth(4);
        assertEquals("5", data.getId());

        //
        // generic list appends to empty list
        //
        s1 = new StudentList();
        s2 = new StudentList();

        itr1 = new DListIterator(s1.header);
        s1.insert(a, itr1);
        itr1.next();
        s1.insert(b, itr1);
        itr1.next();

        s1.append(s2);
        data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());

        // must be able to iterate back from the end of the list
        ir = new DListIterator(s1.header);
        ir.previous();
        s = (Student) ir.previous();
        assertNotNull(s);
        assertEquals("2", s.getId());
        s = (Student) ir.previous();
        assertEquals("1", s.getId());

        // changes to s2 does not affect s1
        s2.insert(c, new DListIterator(s2.header));

        data = (Student) s1.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) s1.findKth(1);
        assertEquals("2", data.getId());
        assertEquals(2, s1.size());

    }

    @Test
    public void testGender() throws Exception {
        Student a = new Student("1", "a", "female");
        Student b = new Student("2", "b", "male");
        Student c = new Student("3", "c", "female");
        Student d = new Student("4", "d", "male");
        Student e = new Student("5", "e", "female");

        StudentList s1 = new StudentList();
        DListIterator itr1 = new DListIterator(s1.header);
        s1.insert(a, itr1);
        itr1.next();
        s1.insert(b, itr1);
        itr1.next();
        s1.insert(c, itr1);
        itr1.next();
        s1.insert(d, itr1);
        itr1.next();
        s1.insert(e, itr1);
        itr1.next();

        CDLinkedList males = s1.gender(0);
        CDLinkedList females = s1.gender(1);
        CDLinkedList what = s1.gender(2);

        assertEquals(2, males.size());
        Student data = (Student) males.findKth(0);
        assertEquals("2", data.getId());
        data = (Student) males.findKth(1);
        assertEquals("4", data.getId());

        assertEquals(3, females.size());
        data = (Student) females.findKth(0);
        assertEquals("1", data.getId());
        data = (Student) females.findKth(1);
        assertEquals("3", data.getId());
        data = (Student) females.findKth(2);
        assertEquals("5", data.getId());

        assertNull(what);

        StudentList maleOnly = new StudentList();
        itr1 = new DListIterator(maleOnly.header);
        maleOnly.insert(b, itr1);
        itr1.next();
        maleOnly.insert(d, itr1);

        CDLinkedList femalesFromMales = maleOnly.gender(1);
        assertTrue(femalesFromMales.isEmpty());

        StudentList femaleOnly = new StudentList();
        itr1 = new DListIterator(femaleOnly.header);
        maleOnly.insert(a, itr1);
        itr1.next();
        maleOnly.insert(c, itr1);

        CDLinkedList malesFromFemales = femaleOnly.gender(0);
        assertTrue(malesFromFemales.isEmpty());
    }
}
