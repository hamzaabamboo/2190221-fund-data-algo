package heap;

public class HuffmanNode implements Comparable {
    static String ans = "";
    static char[] codes = new char[40];
    int frequency;
    char c;
    HuffmanNode left, right;

    public HuffmanNode(int f, char ss, HuffmanNode l, HuffmanNode r) {
        frequency = f;
        c = ss;
        left = l;
        right = r;

        for (int i = 0; i < 40; i++) {
            codes[i] = ' ';
        }
    }

    public static HuffmanNode buildHuffmanTree(Heap h) throws Exception {
        //Create a Huffman Tree from a given
        // heap. Returns the node that roots the resulting tree.
        while (h.size > 1) {
            HuffmanNode n1 = (HuffmanNode) h.pop();
            HuffmanNode n2 = (HuffmanNode) h.pop();

            HuffmanNode left;
            HuffmanNode right;
            if (n1.frequency < n2.frequency) {
                left = n1;
                right = n2;
            } else {
                left = n2;
                right = n1;
            }
            HuffmanNode n = new HuffmanNode(n1.frequency + n2.frequency, ' ', left, right);
            h.add(n);
        }
        //default return
        return (HuffmanNode) h.pop();
    }

    public static void printCodes(HuffmanNode r, int k) {

        if (r.left == null && r.right == null) {
            codes[k] = ' ';
            ans = ans + r.c + ": ";
            int i = 0;
            while (codes[i] != ' ') {
                ans = ans + codes[i];
                i++;
            }
            ans = ans + " \n";
        } else {
            codes[k] = '0';
            printCodes(r.left, k + 1);
            codes[k] = '1';
            printCodes(r.right, k + 1);
        }

    }

    public static void printCodes(HuffmanNode r) {
        printCodes(r, 0);
    }

    public static void resetCodeArray() {
        codes = new char[40];
        for (int i = 0; i < 40; i++) {
            codes[i] = ' ';
        }
    }

    public static void resetCodeString() {
        ans = "";
    }

    public static void main(String[] args) throws Exception {

        //This is an example for you own testing.
        Heap heap1 = new Heap();
        HuffmanNode a = new HuffmanNode(5000, 'a', null, null);
        HuffmanNode b = new HuffmanNode(10000, 'b', null, null);
        HuffmanNode c = new HuffmanNode(20000, 'c', null, null);
        HuffmanNode d = new HuffmanNode(31000, 'd', null, null);
        HuffmanNode e = new HuffmanNode(34000, 'e', null, null);

        heap1.add(a);
        heap1.add(b);
        heap1.add(c);
        heap1.add(d);
        heap1.add(e);

        HuffmanNode r = HuffmanNode.buildHuffmanTree(heap1);

        HuffmanNode.printCodes(r);
        System.out.println(HuffmanNode.ans);
    }

    @Override
    public int compareTo(Object o) {
        HuffmanNode h;

        h = (HuffmanNode) o;

        if (frequency < h.frequency)
            return -1;
        if (frequency > h.frequency)
            return 1;
        return 0;

    }

}
