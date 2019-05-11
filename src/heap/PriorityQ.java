package heap;

public interface PriorityQ {
    // Postcondition: return the number of
    // items in this priority queue.
    int size();

    // Postcondition: return true if this priority
    // queue does not store any item, otherwise return false.
    boolean isEmpty();

    // Postcondition: element is
    // added to priority queue.
    void add(Object element) throws Exception;

    // Throws NoSuchElementException if heap is empty.
    // Postcondition: return the most important object.
    Object top() throws Exception;

    // Throws NoSuchElementException if heap is empty.
    // Postcondition: remove and return the most important object
    Object pop() throws Exception;
}
