package linkedlist;

public interface Iterator<T> {

    boolean hasNext();

    boolean hasPrevious();

    T next() throws Exception;
    // move iterator to the next position,
    // then returns the value at that position.

    T previous() throws Exception;
    // return the value at current position,
    // then move the iterator back one position.

    void set(T value);


}
