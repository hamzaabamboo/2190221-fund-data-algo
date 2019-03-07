package lab.lab_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestAircraft {

    @Test
    public void testAircraft() {
        Aircraft a = new Aircraft();
        assertEquals(0, a.getCurrentSpeed());
        assertEquals(100, a.getMaxSpeed());
    }

    @Test
    public void testAircraftIntInt() {
        Aircraft a1;

        a1 = new Aircraft(24, 150);
        assertEquals(24, a1.getCurrentSpeed());
        assertEquals(150, a1.getMaxSpeed());

        Aircraft b = new Aircraft(-1, 150);
        assertEquals(0, b.getCurrentSpeed());
        assertEquals(150, b.getMaxSpeed());

        Aircraft c = new Aircraft(151, 150);
        assertEquals(150, c.getCurrentSpeed());
        assertEquals(150, c.getMaxSpeed());

        Aircraft d = new Aircraft(55, 44);
        assertEquals(50, d.getCurrentSpeed());
        assertEquals(50, d.getMaxSpeed());
    }

    @Test
    public void testGetCurrentSpeed() {
        Aircraft d = new Aircraft(55, 44);
        assertEquals(50, d.getCurrentSpeed());
    }

    @Test
    public void testSetCurrentSpeed() {
        Aircraft d = new Aircraft(0, 200);
        d.setCurrentSpeed(-1);
        assertEquals(0, d.getCurrentSpeed());

        d.setCurrentSpeed(250);
        assertEquals(200, d.getCurrentSpeed());

        d.setCurrentSpeed(177);
        assertEquals(177, d.getCurrentSpeed());

    }

    @Test
    public void testGetMaxSpeed() {
        Aircraft d = new Aircraft(55, 44);
        assertEquals(50, d.getMaxSpeed());

        d = new Aircraft(55, 500);
        assertEquals(500, d.getMaxSpeed());
    }

    @Test
    public void testSetMaxSpeed() {
        Aircraft d = new Aircraft(55, 44);
        d.setMaxSpeed(-33);
        assertEquals(50, d.getMaxSpeed());
        assertEquals(50, d.getCurrentSpeed());

        d.setMaxSpeed(100);
        assertEquals(100, d.getMaxSpeed());
        assertEquals(50, d.getCurrentSpeed());

        d.setCurrentSpeed(75);
        d.setMaxSpeed(68);
        assertEquals(68, d.getMaxSpeed());
        assertEquals(68, d.getCurrentSpeed());

        d.setCurrentSpeed(45);
        d.setMaxSpeed(0);
        assertEquals(50, d.getMaxSpeed());
        assertEquals(45, d.getCurrentSpeed());
    }

    @Test
    public void testToString() {
        Aircraft a, b;
        a = new Aircraft(24, 150);

        String aa = a.toString();
        assertEquals("aircraft: speed= 24, maxSpeed= 150", aa);

        a.setMaxSpeed(77);
        a.setCurrentSpeed(100);
        aa = a.toString();
        assertEquals("aircraft: speed= 77, maxSpeed= 77", aa);


    }

    @Test
    public void testEqualsObject() {
        Aircraft a, b;
        a = new Aircraft(24, 150);
        b = new Aircraft(24, 150);
        assertTrue(a.equals(b));

        a.setCurrentSpeed(33);
        assertFalse(a.equals(b));

        b.setCurrentSpeed(33);
        assertTrue(a.equals(b));

        a.setMaxSpeed(77);
        assertFalse(a.equals(b));

        b.setMaxSpeed(77);
        assertTrue(a.equals(b));
    }

}
