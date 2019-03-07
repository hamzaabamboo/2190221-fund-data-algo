package queue;

import java.util.ArrayDeque;

public class TestQueue<T> {
    public ArrayDeque<T> q, q2;

    public T findValue(int v) {
        ArrayDeque r = q.clone();
        for (int i = 0; i < v; i++) r.addLast(r.removeFirst());
        return (T) r.getFirst();
    }

    public void crossOver(int p1, int p2) {
        int dq1 = q.size() - p1;
        int dq2 = q2.size() - p2;
        cycle(p1, q);
        for (int i = 0; i < dq1; i++) q2.addLast(q.removeFirst());
        cycle(p2, q2);
        for (int i = 0; i < dq2; i++) q.addLast(q2.removeFirst());
        cycle(dq1, q2);
    }

    public void swap(int p1, int p2) {
        T k1 = findValue(p1);
        T k2 = findValue(p2);
        cycle(p1, q);
        q.removeFirst();
        q.addFirst(k2);
        cycle(p2 - p1, q);
        q.removeFirst();
        q.addFirst(k1);
        cycle(q.size() - p2, q);
    }

    public static <T extends Comparable> ArrayDeque<T> combine(ArrayDeque<T> q1, ArrayDeque<T> q2) {
        ArrayDeque<T> res = new ArrayDeque<>();
        while (!(q1.isEmpty() && q2.isEmpty())) {
            while (!q1.isEmpty() && (q2.isEmpty() || q1.getFirst().compareTo(q2.getFirst()) < 0)) {
                res.addLast(q1.removeFirst());
            }
            while (!q2.isEmpty() && (q1.isEmpty() || q2.getFirst().compareTo((q1.getFirst())) < 0)) {
                res.addLast(q2.removeFirst());
            }
        }
        return res;
    }

    public void cycle(int n, ArrayDeque<T> que) {
        if (n < 0) n = que.size() + n;
        for (int i = 0; i < n; i++) que.addLast(que.removeFirst());
    }
}
