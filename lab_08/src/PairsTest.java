import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PairsTest {

    @Test
    public void testallPairs() {
        int[] a = {7, -3, 1, 8, 2, -2, 3, 4, 5, -1, -4, -6};
        ArrayList<Pair> r = Pairs.allPairs(a);

        Pair x = r.get(0);
        Pair y = r.get(1);
        Pair z = r.get(2);
        Pair w = r.get(11);

        assertEquals(7, x.first);
        assertEquals(-3, x.second);
        assertEquals(-3, y.first);
        assertEquals(1, y.second);
        assertEquals(1, z.first);
        assertEquals(8, z.second);
        assertEquals(-6, w.first);
        assertEquals(7, w.second);

    }

    @Test
    public void testallPairs02() {
        int[] a = {7, -3, 1, 8, 2, -2, 3, 4, 5, -1, -4, -6};
        Hashtable<Integer, Integer> h = Pairs.allPairs02(a);
        assertEquals(1, (int) h.get(-3));
        assertEquals(3, (int) h.get(-2));
        assertEquals(7, (int) h.get(-6));

    }

    @Test(expected = Exception.class)
    public void testfind01Exception() throws Exception {
        int[] a = {7, -3, 1, 8, 2, -2, 3, 4, 5, -1, -4, -6};
        ArrayList<Pair> r = Pairs.allPairs(a);
        Pairs.find(r, 0);
    }

    @Test
    public void testfind01Normal() throws Exception {
        int[] a = {7, -3, 1, 8, 2, -2, 3, 4, 5, -1, -4, -6};
        ArrayList<Pair> r = Pairs.allPairs(a);
        assertEquals(-6, Pairs.find(r, -4));
    }

    @Test(expected = NullPointerException.class)
    public void testfind02Exception() throws Exception {
        int[] a = {7, -3, 1, 8, 2, -2, 3, 4, 5, -1, -4, -6};
        Hashtable<Integer, Integer> h = Pairs.allPairs02(a);
        Pairs.find02(h, 0);
    }

    @Test
    public void testfind02Normal() throws Exception {
        int[] a = {7, -3, 1, 8, 2, -2, 3, 4, 5, -1, -4, -6};
        Hashtable<Integer, Integer> h = Pairs.allPairs02(a);
        assertEquals(7, Pairs.find02(h, -6));
        assertEquals(-3, Pairs.find02(h, 7));
        assertEquals(-2, Pairs.find02(h, 2));
        assertEquals(-1, Pairs.find02(h, 5));
    }

    @Test
    public void testTime() throws Exception {
        int[] a = new int[10000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        ArrayList<Pair> r = Pairs.allPairs(a);
        Hashtable<Integer, Integer> h = Pairs.allPairs02(a);

        double t1 = System.currentTimeMillis();
        Pairs.find(r, 9000000);
        double t2 = System.currentTimeMillis();
        double diff1 = t2 - t1;
        System.out.println(diff1);

        double t3 = System.currentTimeMillis();
        Pairs.find02(h, 9000000);
        double t4 = System.currentTimeMillis();
        double diff2 = t4 - t3;
        System.out.println(diff2);
        assertTrue(diff1 > diff2);

    }

}
