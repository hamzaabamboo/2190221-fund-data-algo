public interface Iterator {

    boolean hasNext();

    boolean hasPrevious();

    Object next() throws Exception;
    // move iterator to the next position,
    // then returns the value at that position.

    Object previous() throws Exception;
    // return the value at current position,
    // then move the iterator back one position.

    void set(Object value);


}
