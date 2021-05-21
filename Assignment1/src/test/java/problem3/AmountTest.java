package problem3;

import org.junit.Before;
import org.junit.Test;
import problem2.Time;

import static org.junit.Assert.*;

public class AmountTest {
    Amount mine;
    int numCents; //total number of cents in the Amount object "mine"

    @Before
    public void setUp() throws Exception {
        mine = new Amount(80000, 25);
        numCents = 8000025;
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest1(){
        //should throw exception due to invalid number of dollars
        Amount invalidDollars = new Amount(-100, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorExceptionTest2(){
        //should throw exception due to invalid number of cents
        Amount invalidCents = new Amount(0, 999);
    }

    @Test
    public void getDollars() {
        assertEquals(80000, mine.getDollars());
    }

    @Test
    public void getCents() {
        assertEquals(25, mine.getCents());
    }

    @Test
    public void changeDollars() {
        Amount change1 = mine.changeDollars(50000);
        assertEquals(50000, change1.getDollars());
        assertEquals(25, change1.getCents());
    }

    @Test
    public void changeCents() {
        Amount change2 = mine.changeCents(99);
        assertEquals(80000, change2.getDollars());
        assertEquals(99, change2.getCents());
    }

    @Test
    public void convertToCents(){
        assertEquals(numCents, mine.convertToCents());
    }

    @Test
    public void convertToAmount(){
        Amount afterConversion = Amount.convertToAmount(numCents);
        assertEquals(80000, afterConversion.getDollars());
        assertEquals(25,afterConversion.getCents());
    }

    @Test
    public void addingToBalance(){
        Amount toBeAdded = new Amount(1000, 0);
        Amount newMineAdd = mine.addingToBalance(toBeAdded);
        assertEquals(81000, newMineAdd.getDollars());
        assertEquals(25, newMineAdd.getCents());
    }

    @Test
    public void removingFromBalance(){
        Amount toBeRemoved = new Amount(1000, 0);
        Amount newMineRemove = mine.removingFromBalance(toBeRemoved);
        assertEquals(79000, newMineRemove.getDollars());
        assertEquals(25, newMineRemove.getCents());
    }
}