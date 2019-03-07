package bst;

public class BST<T extends Comparable> {
    public BSTNode<T> root;
    public int size;

    public BST(BSTNode<T> root, int size) {
        this.root = root;
        this.size = size;
    }

    public TreeIterator find(T v) {
        BSTNode temp = root;

        while (temp != null && temp.data != v) {
            if (v.compareTo(temp.data) < 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (temp == null) // not found
            return null;
        return new TreeIterator(temp);
    }

    public void insert(T v) {
        BSTNode<T> cur = root;
        if (root == null) {
            root = new BSTNode<>(v);
            size++;
        }
        while (cur != null) {
            if (v.compareTo(cur.data) > 0) {
                if (cur.right == null) {
                    cur.right = new BSTNode<>(v);
                    cur.right.parent = cur;
                    size++;
                    break;
                } else cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = new BSTNode<>(v);
                    cur.left.parent = cur;
                    size++;
                    break;
                } else cur = cur.left;
            }
        }
    }

    public BST<T> fixTree() {
        BST<T> res = new BST<>(null, 0);
        insertTree(root, res);
        return res;
    }

    void insertTree(BSTNode<T> n, BST<T> tree) {
        if (n == null) return;
        tree.insert(n.data);
        insertTree(n.left, tree);
        insertTree(n.right, tree);
    }

    public BST<T> cloneTree() {
        return new BST<>(copy(root, null), 0);
    }

    public int height() {
        return height(root);
    }

    public int height(BSTNode n) {
        if (n == null) return 0;
        int lh = 1 + height(n.left);
        int rh = 1 + height(n.right);
        return lh > rh ? lh : rh;
    }

    private BSTNode<T> copy(BSTNode<T> s, BSTNode<T> d) {
        if (s == null) return null;
        d = new BSTNode<>(s.data, null, null, d);
        d.left = copy(s.left, d.left);
        d.right = copy(s.right, d.right);
        return d;
    }

    public BSTNode<T> createMirror() {
        return createMirror(root, null);
    }

    public BSTNode<T> createMirror(BSTNode<T> n, BSTNode<T> parent) {
        if (n == null) return null;
        BSTNode<T> d = new BSTNode<>(n.data, null, null, parent);
        d.left = createMirror(n.right, d);
        d.right = createMirror(n.left, d);
        return d;
    }

    public BST<T> greaterThanTree(T v) {
        BST<T> res = new BST<>(null, 0);
        greaterThanTree(root, v, res);
        return res;
    }

    public void greaterThanTree(BSTNode<T> node, T v, BST<T> d) {
        if (node == null) return;
        if (node.data.compareTo(v) > 0) d.insert(node.data);
        greaterThanTree(node.left, v, d);
        greaterThanTree(node.right, v, d);
    }

    public T findMax() {
        return findMax(root);
    }

    public T findMax(BSTNode<T> node) {
        if (node.right == null) return node.data;
        return findMax(node.right);
    }

    public void combine(BST<T> that) {
        combine(this, that.root);
    }

    public void combine(BST<T> d, BSTNode<T> s) {
        if (s == null) return;
        if (d.find(s.data) == null) {
            d.insert(s.data);
        }
        combine(d, s.left);
        combine(d, s.right);
    }
}
