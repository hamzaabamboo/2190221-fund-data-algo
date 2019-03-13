

public interface Iterator {

    boolean hasNext();

    boolean hasPrevious();

    int next() throws Exception;
    // move iterator to the next position,
    // then returns the value at that position.

    int previous() throws Exception;
    // return the value at current position,
    // then move the iterator back one position.

    void set(int value);

}
