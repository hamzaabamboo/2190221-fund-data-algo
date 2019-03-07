public class PriorityQueue {
    MyQueue q;

    public PriorityQueue(MyQueue q) {
        super();
        this.q = q;
    }

    // implement this.
    public void push(int x) throws Exception {
        q.insertLast(x);
    }

    // implement this.
    public void pop() throws Exception {
        int min = top();
        for (int i = 0; i < q.size(); i++) {
            int v = q.removeFirst();
            if (v != min) q.insertLast(v);
            else break;
        }
    }

    // implement this
    public int top() throws Exception {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < q.size(); i++) {
            int v = q.removeFirst();
            if (v < min) min = v;
            q.insertLast(v);
        }
        return min;
    }

}
