package linkedlist;

public interface Iterator<T> {

    public boolean hasNext();

    public boolean hasPrevious();

    public T next() throws Exception;
    // move iterator to the next position,
    // then returns the value at that position.

    public T previous() throws Exception;
    // return the value at current position,
    // then move the iterator back one position.

    public void set(T value);


}
