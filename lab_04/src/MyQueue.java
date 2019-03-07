//Queue that stores integers.
public interface MyQueue {

    //Return the value of the first data.
    //Throw Exception if the queue is empty.
    int front() throws EmptyQueueException;

    //Return the value of the last data.
    //Throw Exception if the queue is empty.
    int back() throws EmptyQueueException;

    //Remove the first data (return its value too).
    //Throw Exception if the queue is empty.
    int removeFirst() throws EmptyQueueException;

    //Insert new data after the last data. The new data becomes the new last data.
    //Throw exception if the insert fails for some reason.
    void insertLast(int data) throws Exception;

    //Check if the queue is empty.
    boolean isEmpty();

    //Check if the queue has no more space to store new data.
    boolean isFull();

    //Return the number of data currently stored in the queue.
    int size();
}
