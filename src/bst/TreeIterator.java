package bst;

public class TreeIterator<T> implements Iterator<T> {

    BSTNode<T> currentNode;

    public TreeIterator(BSTNode currentNode) {
        this.currentNode = currentNode;
    }

    @Override
    public boolean hasNext() {
        BSTNode temp = currentNode;

        if (temp.right != null) {
            return true;
        }

        BSTNode p = temp.parent;
        while (p != null && p.right == temp) {
            temp = p;
            p = temp.parent;
        }

        return p != null;
    }

    @Override
    public boolean hasPrevious() {
        BSTNode temp = currentNode;

        if (temp.left != null) {
            return true;
        }

        BSTNode p = temp.parent;
        while (p != null && p.left == temp) {
            temp = p;
            p = temp.parent;
        }

        return p != null;

    }

    @Override
    public T next() throws Exception {
        // Throw exception if the next data
        // does not exist.
        BSTNode temp = currentNode;

        if (temp.right != null) {
            temp = temp.right;
            while (temp.left != null) {
                temp = temp.left;
            }
        } else {
            BSTNode p = temp.parent;
            while (p != null && p.right == temp) {
                temp = p;
                p = temp.parent;
            }
            temp = p;
        }

        if (temp == null) // hasNext() == false
            throw new Exception();
        currentNode = temp;
        return currentNode.data;
    }

    @Override
    public T previous() throws Exception {
        // Throw exception if the previous data
        // does not exist.
        BSTNode<T> temp = currentNode;
        T d = currentNode.data;

        if (temp.left != null) {
            temp = temp.left;
            while (temp.right != null) {
                temp = temp.right;
            }
        } else {
            BSTNode p = temp.parent;
            while (p != null && p.left == temp) {
                temp = p;
                p = temp.parent;
            }
            temp = p;
        }

        if (temp == null) // hasPrevious() == false
            throw new Exception();
        currentNode = temp;
        return d;

    }

    @Override
    public void set(T value) {
        currentNode.data = value;
    }

}
