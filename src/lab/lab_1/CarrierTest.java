package lab.lab_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarrierTest {

    @Test
    public void testCarrier() {
        Carrier c = new Carrier();
        Aircraft[] a = c.getCrafts();
        assertEquals(5, a.length);

        assertNull(a[0]);
        assertNull(a[1]);
        assertNull(a[2]);
        assertNull(a[3]);
        assertNull(a[4]);
    }

    @Test
    public void testCarrierAircraftArray() {
        Aircraft[] a = new Aircraft[3];
        a[0] = new Aircraft(25, 100);
        a[1] = new Aircraft(35, 200);
        a[2] = new Aircraft(45, 300);

        Carrier c = new Carrier(a);

        Aircraft[] b = c.getCrafts();
        assertTrue(b[0] == a[0]);
        assertTrue(b[1] == a[1]);
        assertTrue(b[2] == a[2]);


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
        assertTrue(c.planeLand(a1));
        Aircraft[] b = c.getCrafts();
        assertTrue(b[0] == a1);
        assertNull(b[1]);
        assertNull(b[2]);
        assertNull(b[3]);
        assertNull(b[4]);

        assertTrue(c.planeLand(a2));
        assertTrue(c.planeLand(a3));
        b = c.getCrafts();
        assertTrue(b[0] == a1);
        assertTrue(b[1] == a2);
        assertTrue(b[2] == a3);
        assertNull(b[3]);
        assertNull(b[4]);

        assertTrue(c.planeLand(a4));
        assertTrue(c.planeLand(a5));
        assertFalse(c.planeLand(a6));
        b = c.getCrafts();
        assertTrue(b[0] == a1);
        assertTrue(b[1] == a2);
        assertTrue(b[2] == a3);
        assertTrue(b[3] == a4);
        assertTrue(b[4] == a5);

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

        assertTrue(c.planeTakeoff(a2));
        Aircraft[] b = c.getCrafts();
        assertNull(b[1]);

        assertTrue(c.planeTakeoff(a3));
        b = c.getCrafts();
        assertNull(b[2]);

        assertFalse(c.planeTakeoff(a5));
        b = c.getCrafts();
        assertTrue(b[0] == a1);
        assertNull(b[1]);
        assertNull(b[2]);

        assertEquals(10, a2.getCurrentSpeed());
        assertEquals(10, a2.getCurrentSpeed());

    }

}
