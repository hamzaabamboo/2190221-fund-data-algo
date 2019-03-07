import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarrierTest {

    @Test
    public void testCarrier() {
        Carrier c = new Carrier();
        Aircraft[] a = c.getCrafts();
        Assert.assertEquals(5, a.length);

        Assert.assertNull(a[0]);
        Assert.assertNull(a[1]);
        Assert.assertNull(a[2]);
        Assert.assertNull(a[3]);
        Assert.assertNull(a[4]);
    }

    @Test
    public void testCarrierAircraftArray() {
        Aircraft[] a = new Aircraft[3];
        a[0] = new Aircraft(25, 100);
        a[1] = new Aircraft(35, 200);
        a[2] = new Aircraft(45, 300);

        Carrier c = new Carrier(a);

        Aircraft[] b = c.getCrafts();
        Assert.assertSame(b[0], a[0]);
        Assert.assertSame(b[1], a[1]);
        Assert.assertSame(b[2], a[2]);


    }

    @Test
    public void testGetCrafts() {
        Aircraft[] a = new Aircraft[3];
        a[0] = new Aircraft(25, 100);
        a[1] = new Aircraft(35, 200);
        a[2] = new Aircraft(45, 300);

        Carrier c = new Carrier(a);
        Aircraft[] b = c.getCrafts();
        assertEquals(0, b[0].getCurrentSpeed());
        assertEquals(100, b[0].getMaxSpeed());
        assertEquals(0, b[1].getCurrentSpeed());
        assertEquals(200, b[1].getMaxSpeed());
        assertEquals(0, b[2].getCurrentSpeed());
        assertEquals(300, b[2].getMaxSpeed());

    }

    @Test
    public void testPlaneLand() {
        Aircraft a1 = new Aircraft(25, 100);
        Aircraft a2 = new Aircraft(35, 100);
        Aircraft a3 = new Aircraft(45, 100);
        Aircraft a4 = new Aircraft(55, 100);
        Aircraft a5 = new Aircraft(65, 100);
        Aircraft a6 = new Aircraft(75, 100);

        Carrier c = new Carrier();
        Assert.assertTrue(c.planeLand(a1));
        Aircraft[] b = c.getCrafts();
        Assert.assertSame(b[0], a1);
        Assert.assertNull(b[1]);
        Assert.assertNull(b[2]);
        Assert.assertNull(b[3]);
        Assert.assertNull(b[4]);

        Assert.assertTrue(c.planeLand(a2));
        Assert.assertTrue(c.planeLand(a3));
        b = c.getCrafts();
        Assert.assertSame(b[0], a1);
        Assert.assertSame(b[1], a2);
        Assert.assertSame(b[2], a3);
        Assert.assertNull(b[3]);
        Assert.assertNull(b[4]);

        Assert.assertTrue(c.planeLand(a4));
        Assert.assertTrue(c.planeLand(a5));
        Assert.assertFalse(c.planeLand(a6));
        b = c.getCrafts();
        Assert.assertSame(b[0], a1);
        Assert.assertSame(b[1], a2);
        Assert.assertSame(b[2], a3);
        Assert.assertSame(b[3], a4);
        Assert.assertSame(b[4], a5);

        assertEquals(0, b[0].getCurrentSpeed());
        assertEquals(0, b[1].getCurrentSpeed());
        assertEquals(0, b[2].getCurrentSpeed());
        assertEquals(0, b[3].getCurrentSpeed());
        assertEquals(0, b[4].getCurrentSpeed());

    }

    @Test
    public void testPlaneTakeoff() {
        Aircraft a1 = new Aircraft(25, 100);
        Aircraft a2 = new Aircraft(35, 100);
        Aircraft a3 = new Aircraft(45, 100);
        Aircraft a4 = new Aircraft(55, 100);
        Aircraft a5 = new Aircraft(65, 100);
        Aircraft a6 = new Aircraft(75, 100);

        Carrier c = new Carrier();
        c.planeLand(a1);
        c.planeLand(a2);
        c.planeLand(a3);

        Assert.assertTrue(c.planeTakeoff(a2));
        Aircraft[] b = c.getCrafts();
        Assert.assertNull(b[1]);

        Assert.assertTrue(c.planeTakeoff(a3));
        b = c.getCrafts();
        Assert.assertNull(b[2]);

        Assert.assertFalse(c.planeTakeoff(a5));
        b = c.getCrafts();
        Assert.assertSame(b[0], a1);
        Assert.assertNull(b[1]);
        Assert.assertNull(b[2]);

        assertEquals(10, a2.getCurrentSpeed());
        assertEquals(10, a2.getCurrentSpeed());

    }

}
