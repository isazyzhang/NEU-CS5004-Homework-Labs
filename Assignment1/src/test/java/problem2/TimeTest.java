package problem2;

import org.junit.Before;
import org.junit.Test;
import problem1.Owner;

import static org.junit.Assert.*;

public class TimeTest {
    Time validTime;
    int numSecs; // number of seconds in the Time object "validTime"

    @Before
    public void setUp() throws Exception {
        validTime = new Time(11, 54, 23);
        numSecs = 42863;
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest1(){
        //should throw exception due to invalid number of hours
        Time invalid1 = new Time(29, 50, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest2(){
        //should throw exception due to invalid number of minutes
        Time invalid2 = new Time(10, 70, 22);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorExceptionTest3(){
        //should throw exception due to invalid number of seconds
        Time invalid3 = new Time(10, 10, -17);
    }

    @Test
    public void getHours() {
        assertEquals(11, validTime.getHours());
    }

    @Test (expected=IllegalArgumentException.class)
    public void setHours() {
        validTime.setHours(10);
        assertEquals(10, validTime.getHours());
        validTime.setHours(39); //should throw exception here
    }

    @Test
    public void getMinutes() {
        assertEquals(54, validTime.getMinutes());
    }

    @Test (expected=IllegalArgumentException.class)
    public void setMinutes() {
        validTime.setMinutes(20);
        assertEquals(20, validTime.getMinutes());
        validTime.setMinutes(77); //should throw exception here
    }

    @Test
    public void getSeconds() {
        assertEquals(23, validTime.getSeconds());
    }

    @Test (expected=IllegalArgumentException.class)
    public void setSeconds() {
        validTime.setSeconds(18);
        assertEquals(18, validTime.getSeconds());
        validTime.setSeconds(99); //should throw exception here
    }

    @Test
    public void convertToSeconds(){
        assertEquals(numSecs,validTime.convertToSeconds());
    }

    @Test
    public void convertToTime(){
        Time durationTest = Time.convertToTime(numSecs);
        assertEquals(11, durationTest.getHours());
        assertEquals(54, durationTest.getMinutes());
        assertEquals(23, durationTest.getSeconds());
    }
}