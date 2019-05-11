import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class testAlgorithms {
    @Test
    public void testInsertionSort() throws Exception {
        TestPair tst = new TestPair();
        Algorithms.insertionSort(tst.input);
        assertArrayEquals(tst.input, tst.output);
    }

    @Test
    public void testQuickSort() throws Exception {
        TestPair tst = new TestPair();
        Algorithms.quickSort(tst.input);
        assertArrayEquals(tst.input, tst.output);
    }

    @Test
    public void testSelection() throws Exception {
        TestPair tst = new TestPair();
        Algorithms.selectionSort(tst.input);
        assertArrayEquals(tst.input, tst.output);
    }

    @Test
    public void testMergeSort() throws Exception {
        TestPair tst = new TestPair();
        Algorithms.mergeSort(tst.input);
        assertArrayEquals(tst.input, tst.output);
    }

    @Test
    public void testBubbleSort() throws Exception {
        TestPair tst = new TestPair();
        Algorithms.bubbleSort(tst.input);
        assertArrayEquals(tst.input, tst.output);
    }
}

class TestPair {
    int[] input;
    int[] output;

    TestPair() {
        this(20);
    }

    TestPair(int size) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }
        this.input = arr;
        this.output = new int[arr.length];
        System.arraycopy(this.input, 0, this.output, 0, arr.length);
        Arrays.sort(this.output);
    }
}
