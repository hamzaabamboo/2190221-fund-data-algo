public interface Iterator {
    boolean hasNext();

    Object next() throws Exception;

    void set(Object value);
}
