package lab.lab_2;

public interface Iterator {
    boolean hasNext();

    Object next() throws Exception;

    void set(Object value);
}
