import java.util.ArrayList;
import java.util.Hashtable;

public class Pairs {

    public static ArrayList<Pair> allPairs(int[] a) {
        ArrayList<Pair> result = new ArrayList<Pair>();
        for (int i = 0; i < a.length; i++) {
            Pair p = new Pair();
            p.first = a[i];
            p.second = i + 1 != a.length ? a[i + 1] : a[0];
            result.add(p);
        }
        return result;
    }

    public static Hashtable<Integer, Integer> allPairs02(int[] a) {
        Hashtable<Integer, Integer> h = new Hashtable<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            int first = a[i];
            int second = i + 1 != a.length ? a[i + 1] : a[0];
            h.put(first, second);
        }
        return h;
    }

    public static int find(ArrayList<Pair> a, int key) throws Exception {
        for (Pair p : a) {
            if (p.first == key) return p.second;
        }
        throw new Exception("Booooo");
    }

    public static int find02(Hashtable<Integer, Integer> h, int key) {
        return h.get(key);
    }

    public static void printArrayListPairs(ArrayList<Pair> r) {
        for (Pair pair : r) {
            System.out.print("(" + pair.first + ", " + pair.second + "), ");
        }
        System.out.println();
        System.out.println();
    }

}
