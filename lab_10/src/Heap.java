public class Heap implements PriorityQ {
    Object[] mData;
    int size = 0;

    public Heap() {
        final int DEFAULT_INITIAL_CAPACITY = 11;
        mData = new Comparable[DEFAULT_INITIAL_CAPACITY];
    } // default constructor

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object element) {

        if (++size == mData.length) {
            Object[] newHeap = new Object[2 * mData.length];
            System.arraycopy(mData, 0, newHeap, 0, size);
            mData = newHeap;
        }
        mData[size - 1] = element;
        percolateUp();
    }

    protected void percolateUp() {
        int parent;
        int child = size - 1;
        Comparable temp;
        while (child > 0) {
            parent = (child - 1) / 2;
            if (((Comparable) mData[parent]).compareTo(mData[child]) <= 0)
                break;
            temp = (Comparable) mData[parent];
            mData[parent] = mData[child];
            mData[child] = temp;
            child = parent;
        }
    }

    public Object top() throws Exception {
        if (size == 0)
            throw new Exception("Empty");
        return mData[0];
    }

    public Object pop() throws Exception {
        if (size == 0)
            throw new Exception("Priority queue empty.");
        Object minElem = mData[0];
        mData[0] = mData[size - 1];
        size--;
        percolateDown(0);
        return minElem;
    }

    protected void percolateDown(int start) {
        int parent = start;
        int child = 2 * parent + 1;
        Object temp;
        while (child < size) {
            if (child < size - 1
                    && ((Comparable) mData[child]).compareTo(mData[child + 1]) > 0)
                child++;
            if (((Comparable) mData[parent]).compareTo(mData[child]) <= 0)
                break;
            temp = mData[child];
            mData[child] = mData[parent];
            mData[parent] = temp;
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public int size() {
        return size;
    }

}
