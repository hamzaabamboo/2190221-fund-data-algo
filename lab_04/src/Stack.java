public interface Stack {
    //check if the stack is empty.
    boolean isEmpty();

    //check if the stack is full.
    boolean isFull();

    //set the stack to be an empty stack.
    void makeEmpty();

    //return value on top of stack. If the stack is empty, throw exception.
    int top() throws Exception;

    //remove value on top of stack. If the stack is empty, throw exception.
    void pop() throws Exception;

    //push data on top of stack.
    void push(int data) throws Exception;

}
