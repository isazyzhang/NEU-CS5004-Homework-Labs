package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HolderTest {
    Holder jane;


    @Before
    public void setUp() throws Exception {
        jane = new Holder("Jane", "Doe");
    }

    @Test
    public void getFirstName() {
        assertEquals("Jane", jane.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Doe", jane.getLastName());
    }

    @Test
    public void changeFirstName() {
        Holder janine = jane.changeFirstName("Janine");
        assertEquals("Janine", janine.getFirstName());
        assertEquals("Doe", janine.getLastName());
    }

    @Test
    public void changeLastName() {
        Holder smith = jane.changeLastName("Smith");
        assertEquals("Jane", smith.getFirstName());
        assertEquals("Smith", smith.getLastName());
    }
}