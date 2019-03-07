package linkedlist;

public class DListNode<T> {
    // Constructors
    DListNode(T data) {
        this(data, null, null);
    }

    DListNode(T theElement, DListNode n, DListNode p) {
        data = theElement;
        nextNode = n;
        previousNode = p;
    }

    // Friendly data; accessible by other package routines
    public T data;
    public DListNode<T> nextNode, previousNode;
}