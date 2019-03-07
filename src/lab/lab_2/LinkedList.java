package lab.lab_2;

class ListNode {
    // Constructors
    ListNode(Object theElement) {
        this(theElement, null);
    }

    ListNode(Object theElement, ListNode n) {
        data = theElement;
        nextNode = n;
    }

    // Friendly data; accessible by other package routines
    Object data;
    ListNode nextNode;
}

public class LinkedList {
    ListNode header;

    public LinkedList() {
        header = new ListNode(null);
    }

    public boolean isEmpty() {
        return header.nextNode == null;
    }

    /**
     * make the list empty.
     */
    public void makeEmpty() {
        header.nextNode = null;
    }

    public void insert(Object value, Iterator p) throws Exception {
        if (p == null || !(p instanceof MyListIterator))
            throw new Exception();
        MyListIterator p2 = (MyListIterator) p;
        if (p2.currentNode == null)
            throw new Exception();
        ListNode n = new ListNode(value, p2.currentNode.nextNode);
        p2.currentNode.nextNode = n;
    }

    public int find(Object value) throws Exception {
        Iterator itr = new MyListIterator(header);
        int index = -1;
        while (itr.hasNext()) {
            Object v = itr.next();
            index++;
            if (v.equals(value))
                return index; // return the position of value.
        }
        return -1;
    }

    public Iterator findPrevious(Object value) throws Exception {
        Iterator itr1 = new MyListIterator(header);
        Iterator itr2 = new MyListIterator(header);
        if (!itr2.hasNext())
            return null;
        Object currentData = itr2.next();
        while (!currentData.equals(value) && itr2.hasNext()) {
            currentData = itr2.next();
            itr1.next();
        }
        if (currentData.equals(value))
            return itr1;
        return null;

    }

    public void remove(Iterator p) {
        if (p == null || !(p instanceof MyListIterator))
            return;
        MyListIterator p2 = (MyListIterator) p;
        if (p2.currentNode == null || p2.currentNode.nextNode == null)
            return;
        p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
    }

    public void remove(Object value) throws Exception {
        Iterator p = findPrevious(value);
        if (p == null)
            return;
        remove(p);
    }

    // Returns the number of data stored in this list.
    // To be completed by students.
    public int size() throws Exception {
        Iterator it = new MyListIterator(this.header);
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
        }
        return i;
    }

    // Print each contact out, one by one.
    // To be completed by students.
    public void printList() throws Exception {
        MyListIterator it = new MyListIterator(this.header);
        while (it.hasNext()) {
            it.next();
            System.out.println(it.currentNode.data);
        }
    }

    //Return iterator pointing to value that stores a given name, or null otherwise.
    //To be completed by students.
    public Iterator findPosition(String name) throws Exception {
        MyListIterator it = new MyListIterator(this.header);
        while (it.hasNext()) {
            it.next();
            if (((Contact) it.currentNode.data).name.equals(name)) {
                return it;
            }
        }
        return null;
    }

    //add a new contact to the list the contact must be added in such a way that each contact is sorted by name, in alphabetical order.

    public void add(Object c) throws Exception {
        MyListIterator it = new MyListIterator(this.header);
        MyListIterator it2 = new MyListIterator(this.header);
        if (c instanceof Contact) {
            Contact toAdd = (Contact) c;
            ListNode toAddNode = new ListNode(toAdd);
            if (it2.hasNext()) {
                it2.next();
                do {
                    Contact c2 = ((Contact) it2.currentNode.data);
                    if (toAdd.name.compareTo(c2.name) < 0) {
                        // Put in the node
                        it.currentNode.nextNode = toAddNode;
                        toAddNode.nextNode = it2.currentNode;
                        break;
                    } else if (it2.currentNode.nextNode == null) {
                        it2.currentNode.nextNode = toAddNode;
                        return;
                    }
                    it.next();
                    it2.next();
                } while (it2.hasNext());
            } else {
                it2.currentNode.nextNode = toAddNode;
            }
        }
    }

    //Remove the contact pointed by the iterator, i, and then returns an iterator pointing to the next contact.
    //If the removed contact is the last one, return the iterator pointing to the first contact
    //   (if there is no first contact, make the iterator point to header).
    //If i is marking an illegal position that cannot be removed, just return null.
    //To be completed by students.
    public Iterator removeAt(Iterator i) throws Exception {
        // Edge Cases
        MyListIterator it2 = (MyListIterator) i;
        if (i == null || it2.currentNode == null || it2.currentNode.data == null || it2.currentNode == this.header || findPrevious(it2.currentNode.data) == null)
            return null;

        MyListIterator it = (MyListIterator) findPrevious(it2.currentNode.data);

        it.currentNode.nextNode = it2.currentNode.nextNode;
        if (it2.currentNode.nextNode == null) {
            return new MyListIterator(this.header.nextNode == null ? this.header : this.header.nextNode
            );
        } else {
            it2.currentNode = it.currentNode.nextNode;
            return it2;
        }
    }


}