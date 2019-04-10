import java.util.Random;

//------------------------------------------
// Time Complexity of Sorting Algorithms
// by SPJ (14/10/2014)
//------------------------------------------
public class Sorting {

    public static void main(String[] args) throws Exception {
        int repeat = 2;  // repeat each experiment a couple of times and keep the best result (lowest time)

        for (int initialOrder = 0; initialOrder <= 2; initialOrder++) { // 0 = sorted, 1 = random, 2 = reversed
            System.out.printf("\nInitial state = %d\n", initialOrder);
            System.out.printf("size \t time(ms) \n");
            // for (int n = 10000; n <= 160000; n *= 2) {          // bubble, selection, insertion sort
            for (int n = 1000000; n <= 64000000; n *= 2) {      // shell, heap, merge, quick sort
                int[] d = new int[n];
                switch (initialOrder) {
                    case 0:
                        for (int i = 0; i < n; i++) d[i] = i;
                        break;
                    case 1:
                        for (int i = 0; i < n; i++) d[i] = i;
                        Random rnd = new Random(1234567);
                        for (int i = d.length - 1; i > 0; i--) swap(d, i, rnd.nextInt(i));
                        break;
                    case 2:
                        for (int i = 0; i < n; i++) d[i] = n - i;
                }
                long sum = 0;
                long min = 0;
                long time = 0;
                for (int k = 0; k < repeat; k++) {
                    int[] t = d.clone();
                    long start = System.currentTimeMillis();
//-------------------------------------------------
                    // bubbleSort(t);
                    //  selectionSort(t);
                    //  insertionSort(t);
                    //  shellSort(t);
                    //  heapSort(t);
                    //  mergeSort(t);
                    quickSort(t);
//-------------------------------------------------
                    time = System.currentTimeMillis() - start;
                    sum += time;
                    if (min == 0 || time < min) min = time;
                    checkSorted(t);
                }
                //System.out.printf("%d \t %f \n", n, (double) sum / repeat);
                System.out.printf("%d \t %d \n", n, min);
            }
        }
        System.out.println("Finished");
    }

    //-----------------------------------------------------------------
    static void shellSort(int[] d) {
        int h;
        for (h = 1; h <= d.length / 4; h = 2 * h + 1) ;
        for (; h > 0; h /= 2) {
            for (int m = 0; m < h; m++) {
                for (int i = m + h; i < d.length; i += h) {
                    int t = d[i];
                    int j = i - h;
                    while (j >= 0 && t < d[j]) {
                        d[j + h] = d[j];
                        j -= h;
                    }
                    d[j + h] = t;
                }
            }
        }
    }

    //-----------------------------------------------------------------
    public static void quickSort(int[] d) {
        quickSortR(d, 0, d.length - 1);
    }

    private static void quickSortR(int[] d, int left, int right) {
        if (left < right) {
            int j = partition(d, left, right);
            quickSortR(d, left, j - 1);
            quickSortR(d, j + 1, right);
        }
    }

    private static int partition(int[] d, int left, int right) {
        int center = (left + right) / 2;
        if ((d[left] < d[center])) swap(d, left, center);
        if ((d[right] < d[center])) swap(d, center, right);
        if ((d[right] < d[left])) swap(d, left, right);
//    int r = left + (int)(Math.random() * (right - left + 1));
//    swap(d, left, r);
        int p = d[left];
        int i = left, j = right + 1;
        while (i < j) {
            while (p < d[--j]) ;
            while (d[++i] < p) {
                if (i == right) break;
            }
            if (i < j) swap(d, i, j);
        }
        swap(d, left, j);
        return j;
    }

    //-----------------------------------------------------------------
    public static void mergeSort(int[] d) {
        mergeSortR(d, 0, d.length - 1, d.clone());
    }

    private static void mergeSortR(int[] d, int left, int right, int[] t) {
        if (left < right) {
            int m = left + (right - left) / 2;
            mergeSortR(t, left, m, d);
            mergeSortR(t, m + 1, right, d);
            merge(t, left, m, right, d);
        }
    }

    private static void merge(int[] d, int left, int mid,
                              int right, int[] t) {
        int i = left, j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            t[k++] = d[i] < d[j] ? d[i++] : d[j++];
        }
        while (i <= mid) {
            t[k++] = d[i++];
        }
        while (j <= right) {
            t[k++] = d[j++];
        }
    }

    //-----------------------------------------------------------------
    public static void heapSort(int[] d) {
        int size = d.length;
        for (int k = size / 2 - 1; k >= 0; k--) fixDown(d, size, k);
        for (int k = size - 1; k > 0; k--) {
            swap(d, 0, k);
            fixDown(d, --size, 0);
        }
    }

    private static void fixDown(int[] d, int size, int p) {
        int c;
        while ((c = 2 * p + 1) < size) {
            if (c < size - 1 && (d[c] < d[c + 1])) c++;
            if (d[c] <= d[p]) break;
            swap(d, c, p);
            p = c;
        }
    }

    //--------------------------------------------------------
    public static void insertionSort(int[] d) {
        for (int k = 1; k < d.length; k++) {
            int t = d[k];
            int j = k - 1;
            while (j >= 0) {
                if (d[j] <= t) break;
                d[j + 1] = d[j];
                j--;
            }
            d[j + 1] = t;
        }
    }

    //-----------------------------------------------------------------
    public static void selectionSort(int[] d) {
        for (int k = d.length - 1; k > 0; k--) {
            int maxI = 0;
            for (int i = 1; i <= k; i++) {
                if (d[maxI] < d[i]) maxI = i;
            }
            swap(d, maxI, k);
        }
    }

    //-----------------------------------------------------------------
    public static void bubbleSort(int[] d) {
        for (int i = d.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (d[j + 1] < d[j]) swap(d, j, j + 1);
            }
        }
    }

    //-----------------------------------------------------------------
    private static void checkSorted(int[] d) {
        for (int i = 1; i < d.length; i++) {
            if (d[i - 1] > d[i]) throw new RuntimeException("WRONG");
        }
    }

    private static void swap(int[] d, int i, int j) {
        int t = d[i];
        d[i] = d[j];
        d[j] = t;
    }
}
