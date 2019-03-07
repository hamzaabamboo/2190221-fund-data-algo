package stack;

import java.util.Stack;

public class TestStack<T extends Comparable> {
    public Stack<T> s;

    public Stack oddNumbers() {
        Stack res = new Stack<T>();
        Stack tmp = new Stack<T>();
        while (!s.isEmpty()) {
            T v = s.pop();
            if ((int) v % 2 == 1) res.push(v);
            tmp.push(v);
        }
        while (!tmp.isEmpty()) s.push((T) tmp.pop());
        while (!res.isEmpty()) tmp.push(res.pop());
        return tmp;
    }

    public Stack sort() {
        Stack tmp = new Stack<T>();
        while (!s.isEmpty()) {
            T v = s.pop();
            while (!tmp.isEmpty() && ((T) tmp.peek()).compareTo(v) > 0) {
                s.push((T) tmp.pop());
            }
            tmp.push(v);
        }
        return tmp;
    }

    public void removeDup() {
        Stack res = new Stack<T>();
        while (s.size() > 0) {
            T v = s.pop();
            if (!in(v, res)) res.push(v);
        }
        s = res;
    }

    public void removeMin() {
        Stack tmp = new Stack<T>();
        T min = null;
        while (s.size() > 0) {
            T v = s.pop();
            if (min == null || min.compareTo(v) > 0) {
                min = v;
            }
            tmp.push(v);
        }
        while (tmp.size() > 0) {
            T v = (T) tmp.pop();
            if (!v.equals(min)) {
                s.push(v);
            }
        }
    }

    public void insertAtBottom(int p, T v) {
        Stack<T> tmp = new Stack<>();
        while (!s.isEmpty()) tmp.push(s.pop());
        for (int i = 0; i < p; i++) if (!tmp.isEmpty()) s.push(tmp.pop());
        s.push(v);
        while (!tmp.isEmpty()) s.push(tmp.pop());
    }

    public void putIn(T v) {
        Stack<T> tmp = new Stack<>();
        while (s.size() > 0 && s.peek().compareTo(v) > 0) {
            tmp.push(s.pop());
        }
        s.push(v);
        while (tmp.size() > 0) s.push(tmp.pop());
    }

    private boolean in(T v, Stack<T> s) {
        for (Stack<T> t = (Stack) s.clone(); t.size() > 0; t.pop()) {
            if (t.peek() == v) return true;
        }
        return false;
    }
}
