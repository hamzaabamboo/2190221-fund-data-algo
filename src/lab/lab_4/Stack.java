package lab.lab_4;

public interface Stack {
    //check if the practice.stack is empty.
    public boolean isEmpty();

    //check if the practice.stack is full.
    public boolean isFull();

    //set the practice.stack to be an empty practice.stack.
    public void makeEmpty();

    //return value on top of practice.stack. If the practice.stack is empty, throw exception.
    public int top() throws Exception;

    //remove value on top of practice.stack. If the practice.stack is empty, throw exception.
    public void pop() throws Exception;

    //push data on top of practice.stack.
    public void push(int data) throws Exception;

}
