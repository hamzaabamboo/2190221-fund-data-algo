import java.util.Arrays;

public class Algorithms {
    public static void sort(int[] a) {
        Arrays.sort(a);
    }

    public static void sortTwoArrays(int[] a1, int[] a2) {
        int size = a1.length + a2.length;
        int[] r = new int[size];
        for (int i = 0; i < a1.length; i++) {
            r[i] = a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            r[a1.length + i] = a2[i];
        }
        sort(r);
        for (int i = 0; i < a1.length; i++) {
            a1[i] = r[i];
        }
        for (int i = 0; i < a2.length; i++) {
            a2[i] = r[a1.length + i];
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int c = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > c) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = c;
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = -1;
            for (int j = i; j < a.length; j++) {
                if (min < 0) min = j;
                else if (a[j] < a[min]) min = j;
            }
            swap(a, i, min);
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length - i - 1; j++)
                if (a[j] > a[j + 1]) swap(a, j + 1, j);
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + (r - 1)) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void merge(int[] a, int l, int m, int r) {
        int nl = m - l + 1;
        int nr = r - m;

        int[] al = new int[nl];
        int[] ar = new int[nr];

        for (int i = 0; i < nl; i++) al[i] = a[l + i];
        for (int i = 0; i < nr; i++) ar[i] = a[m + i + 1];

        int i = 0;
        int j = 0;
        int k = l;
        while (i < nl && j < nr) {
            if (al[i] <= ar[j]) a[k] = al[i++];
            else a[k] = ar[j++];
            k++;
        }
        while (i < nl) a[k++] = al[i++];
        while (j < nr) a[k++] = ar[j++];
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start > end) return;
        int m = partition(a, start, end);
        quickSort(a, start, m - 1);
        quickSort(a, m + 1, end);
    }

    public static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start - 1; // Lowest
        for (int j = start; j <= end - 1; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, end);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
