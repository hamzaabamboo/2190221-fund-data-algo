package practice.linkedlist;

import practice.bst.BST;
import practice.bst.BSTNode;

public class CDLinkedList<T extends Comparable<T>> {
    public DListNode<T> header;
    public int size;

    public CDLinkedList() {
        size = 0;
        header = new DListNode(null);
        header.nextNode = header;
        header.previousNode = header;
    }

    public boolean isEmpty() {
        return header.nextNode == header;
    }

    /**
     * make the list empty.
     */
    public void makeEmpty() {
        header.nextNode = header;
        header.previousNode = header;
    }

    // put in new data after the position of p.
    public void insert(T data, Iterator p) throws Exception {
        if (p == null || !(p instanceof DListIterator))
            throw new Exception();
        DListIterator p2 = (DListIterator) p;
        if (p2.currentNode == null)
            throw new Exception();

        DListIterator<T> p3 = new DListIterator<>(p2.currentNode.nextNode);
        DListNode<T> n = new DListNode<>(data, p3.currentNode, p2.currentNode);
        p2.currentNode.nextNode = n;
        p3.currentNode.previousNode = n;
        size++;
    }

    // return position number of value found in the list.
    // otherwise, return -1.
    public int find(T data) throws Exception {
        Iterator<T> itr = new DListIterator<>(header);
        int index = -1;
        while (itr.hasNext()) {
            T v = itr.next();
            index++;
            DListIterator itr2 = (DListIterator) itr;
            if (itr2.currentNode == header)
                return -1;
            if (v.equals(data))
                return index; // return the position of value.
        }
        return -1;
    }

    // return data stored at kth position.
    public T findKth(int kthPosition) throws Exception {
        if (kthPosition < 0)
            throw new Exception();// exit the method if the position is
        // less than the first possible
        // position, throwing exception in the process.
        DListIterator<T> itr = new DListIterator<>(header);
        int index = -1;
        while (itr.currentNode.nextNode != header) {
            T v = itr.next();
            index++;
            DListIterator itr2 = (DListIterator) itr;
            if (itr2.currentNode == header)
                throw new Exception();
            if (index == kthPosition)
                return v;
        }
        throw new Exception();
    }

    // Return iterator at position before the first position that stores value.
    // If the value is not found, return null.
    public Iterator findPrevious(T value) throws Exception {
        if (isEmpty())
            return null;
        Iterator<T> itr1 = new DListIterator<>(header);
        Iterator<T> itr2 = new DListIterator<>(header);
        T currentData = itr2.next();
        while (!currentData.equals(value)) {
            currentData = itr2.next();
            itr1.next();
            if (((DListIterator) itr2).currentNode == header)
                return null;
        }
        if (currentData.equals(value))
            return itr1;
        return null;

    }

    // remove content at position just after the given iterator. Skip header if
    // found.
    public void remove(Iterator p) {
        if (isEmpty())
            return;
        if (p == null || !(p instanceof DListIterator))
            return;
        DListIterator p2 = (DListIterator) p;
        if (p2.currentNode == null)
            return;
        if (p2.currentNode.nextNode == header)
            p2.currentNode = header;
        if (p2.currentNode.nextNode == null)
            return;
        DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
        p2.currentNode.nextNode = p3.currentNode;
        p3.currentNode.previousNode = p2.currentNode;
        size--;
    }

    // remove the first instance of the given data.
    public void remove(T value) throws Exception {
        Iterator p = findPrevious(value);
        if (p == null)
            return;
        remove(p);
    }

    // remove data at position p.
    // if p points to header or the list is empty, do nothing.
    public void removeAt(Iterator p) throws Exception {
        if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
                || ((DListIterator) p).currentNode == header)
            return;

        DListIterator p2 = (DListIterator) (findPrevious(p));
        DListNode next = ((DListIterator) p).currentNode.nextNode;
        remove(p2);
        ((DListIterator) p).currentNode = next;
    }

    // Print each contact out, one by one.
    // To be completed by students.
    public void printList() throws Exception {
        DListIterator<T> itr = new DListIterator<>(header);
        while (itr.currentNode.nextNode != header) {
            T data = itr.next();
            System.out.println(data);
        }
    }

    // Returns the number of data stored in this list.
    // To be completed by students.
    public int size() throws Exception {
        DListIterator itr = new DListIterator<>(header);
        int count = 0;
        while (itr.currentNode.nextNode != header) {
            itr.next();
            count++;
        }
        return count;
    }

    // Return iterator pointing to value, or null otherwise.
    // To be completed by students.
    // Not used in class.
    public Iterator findPosition(T value) throws Exception {
        Iterator<T> itr = new DListIterator<>(header);
        while (itr.hasNext()) {
            T data = itr.next();
            if (data.equals(value)) {
                return itr;
            }
        }

        return null;
    }

    // return iterator pointing to location before position.
    public Iterator<T> findPrevious(Iterator<T> position) throws Exception {
        if (position == null)
            return null;
        if (!(position instanceof DListIterator))
            return null;
        if (((DListIterator) position).currentNode == null)
            return null;

        DListIterator<T> p = ((DListIterator<T>) position);
        return new DListIterator<>(p.currentNode.previousNode);
    }

    public CDLinkedList<T> partition(T val) throws Exception {
        CDLinkedList<T> res = new CDLinkedList<>();
        DListIterator<T> itr = new DListIterator<>(header);
        DListIterator<T> itr2 = new DListIterator<>(res.header);
        itr.next();
        while (itr.hasNext() && itr.currentNode != header) {
            if (itr.currentNode.data.compareTo(val) > 0) {
                res.insert(itr.currentNode.data, itr2);
                itr2.next();
                remove(findPrevious(itr));
            }
            itr.next();
        }
        return res;
    }

    public void insertAtFront(T x) throws Exception {
        DListIterator<T> it = new DListIterator<>(header);
        insert(x, it);
    }

    public T removeAtLast() throws Exception {
        DListIterator<T> it = new DListIterator<>(header.previousNode);
        T v = it.currentNode.data;
        removeAt(it);
        return v;
    }

    public void swap(T v1, T v2) throws Exception {
        DListIterator<T> it1 = (DListIterator<T>) findPrevious(v1);
        DListIterator<T> it2 = (DListIterator<T>) findPrevious(v2);
        it1.next();
        it2.next();
        it1.set(v2);
        it2.set(v1);
    }

    public boolean isInFront(T x, T y) throws Exception {
        DListIterator<T> it = (DListIterator) findPosition(x);
        while (it.hasNext() && it.currentNode != header) {
            if (it.currentNode.data.equals(y)) return true;
            it.next();
        }
        return false;
    }

    public CDLinkedList reverseList() throws Exception {
        reverse(header);
        return this;
    }

    public static <T extends Comparable<T>> CDLinkedList<T> sortONLogN(CDLinkedList<T> lst) throws Exception {
        BST<T> tree = new BST<>(null, 0);
        DListIterator<T> itr = new DListIterator<>(lst.header);
        itr.next();
        while (!lst.isEmpty() && itr.hasNext()) {
            tree.insert(itr.currentNode.data);
            lst.removeAt(itr);
        }
        inorderInsertList(tree.root, itr, lst);
        return lst;
    }

    public static <T extends Comparable<T>> void inorderInsertList(BSTNode<T> n, Iterator<T> itr, CDLinkedList<T> d) throws Exception {
        if (n == null) return;
        inorderInsertList(n.left, itr, d);
        d.insert(n.data, itr);
        itr.next();
        inorderInsertList(n.right, itr, d);
    }

    DListNode reverse(DListNode n) {
        DListNode tmp = n.nextNode;
        n.nextNode = n.previousNode;
        n.previousNode = tmp;
        if (n.previousNode == header) return header;
        return reverse(n.previousNode);
    }
}
