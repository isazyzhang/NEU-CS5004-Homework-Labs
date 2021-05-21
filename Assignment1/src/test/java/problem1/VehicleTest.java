package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    Integer myVIN;
    Owner myself;
    Owner anotherPerson;
    Vehicle mine;

    @Before
    public void setUp() throws Exception {
        myVIN = 12345;
        myself = new Owner("Isabella", "Zhang", "1234567890");
        anotherPerson = new Owner("Alicia", "Smith", "1111111111");
        mine = new Vehicle(myVIN, "BXX7999", myself);
    }

    @Test
    public void getVIN() {
        assertEquals(Integer.valueOf(12345), mine.getVIN());
    }

    @Test
    public void getLicensePlate() {
        assertEquals("BXX7999", mine.getLicensePlate());
    }

    @Test
    public void getOwner() {
        assertEquals(myself, mine.getOwner());
    }

    @Test
    public void changeVIN() {
        mine.changeVIN(45678);
        assertEquals(Integer.valueOf(45678), mine.getVIN());
    }

    @Test
    public void changeLicensePlate() {
        mine.changeLicensePlate("PDD0000");
        assertEquals("PDD0000", mine.getLicensePlate());
    }

    @Test
    public void changeOwner() {
        mine.changeOwner(anotherPerson);
        assertEquals(anotherPerson, mine.getOwner());
    }
}