import java.util.ArrayList;

public class ArrayListStack implements Stack {
    private ArrayList<Integer> a;
    private int currentSize;

    // implement a default constructor and all methods from interface Stack.
    // Additional methods maybe required in order to run tests.
    public ArrayListStack() {
        a = new ArrayList<>();
        currentSize = 0;
    }

    public ArrayList<Integer> getA() {
        return a;
    }

    @Override
    public boolean isEmpty() {
        return a.size() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void makeEmpty() {
        a.clear();
    }

    @Override
    public int top() throws Exception {
        return a.get(currentSize - 1);
    }

    @Override
    public void pop() throws Exception {
        a.remove(currentSize - 1);
        currentSize--;
    }

    @Override
    public void push(int data) throws Exception {
        a.add(data);
        currentSize++;
    }

}
