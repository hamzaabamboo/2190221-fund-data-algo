package heap;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeHeap {
    public HeapNode root;

    public int pop() throws Exception {
        Queue<HeapNode> q = new ArrayDeque<>();
        int r = root.element;
        q.add(root.left);
        q.add(root.right);
        int l = r;
        while (!q.isEmpty()) {
            HeapNode c = q.poll();
            l = c.element;
            if (c.left != null) q.add(c.left);
            if (c.right != null) q.add(c.right);
            if (q.size() == 0) {
                if (c.parent.left == c) c.parent.left = null;
                if (c.parent.right == c) c.parent.right = null;
            }
        }
        root.element = l;
        percolateDown(root);
        return r;
    }

    public void percolateDown(HeapNode n) {
        if (n == null) return;
        if (n.left != null && n.right != null) {
            if (n.left.element > n.right.element) {
                int tmp = n.right.element;
                n.right.element = n.element;
                n.element = tmp;
                percolateDown(n.right);
            } else {
                int tmp = n.left.element;
                n.left.element = n.element;
                n.element = tmp;
                percolateDown(n.left);
            }
        }
    }
}

