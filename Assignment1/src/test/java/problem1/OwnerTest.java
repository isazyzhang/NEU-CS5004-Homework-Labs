package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    Owner john;
    //private String invalidNumberTest = "999";

    @Before
    public void setUp() throws Exception {
        john = new Owner("John", "Smith", "8379762251");

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest(){
        //should throw exception here since the object has an invalid phone number
        Owner invalid = new Owner("First", "Last", "333");
    }

    @Test
    public void getFirstName() {
        assertEquals("John", john.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Smith", john.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("8379762251", john.getPhoneNumber());
    }

    @Test
    public void changeFirstName() {
        john.changeFirstName("Richard");
        assertEquals("Richard", john.getFirstName());
    }

    @Test
    public void changeLastName() {
        john.changeLastName("White");
        assertEquals("White", john.getLastName());
    }

    @Test (expected=IllegalArgumentException.class)
    public void changePhoneNumber() {
        john.changePhoneNumber("9273309777");
        assertEquals("9273309777", john.getPhoneNumber());
        john.changePhoneNumber("000"); //should throw exception here
    }

}