package practice.linkedlist;

import java.util.NoSuchElementException;

public class DListIterator<T> implements Iterator<T> {
    public DListNode<T> currentNode; // interested position

    public DListIterator(DListNode<T> theNode) {
        currentNode = theNode;
    }

    @Override
    public boolean hasNext() { // always true for circular list.
        return currentNode.nextNode != null;
    }

    public boolean hasPrevious() { // always true for circular list.
        return currentNode.previousNode != null;
    }


    @Override
    public T next() throws Exception {
        // Throw exception if the next data
        // does not exist.
        if (!hasNext())
            throw new NoSuchElementException();
        currentNode = currentNode.nextNode;
        return currentNode.data;

    }

    public T previous() throws Exception {
        if (!hasPrevious())
            throw new NoSuchElementException();
        T data = currentNode.data;
        currentNode = currentNode.previousNode;
        return data;
    }

    @Override
    public void set(T value) {
        if (value != null) {
            currentNode.data = value;
        }
    }

}
