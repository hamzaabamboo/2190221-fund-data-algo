public class UseStack {

    //implement this method.
    public static Stack sort(Stack s) throws Exception {
        Stack hlp = new ArrayListStack();
        while (!s.isEmpty()) {
            int v = s.top();
            s.pop();
            while (!hlp.isEmpty() && hlp.top() < v) {
                s.push(hlp.top());
                hlp.pop();
            }
            hlp.push(v);
        }
        return hlp;
    }
}
