package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Holder me;
    Account my;
    Amount mine;

    @Before
    public void setUp() throws Exception {
        me = new Holder("Isabella", "Zhang");
        mine = new Amount(90000, 99);
        my = new Account(me, mine);
    }

    @Test
    public void getHolder() {
        assertEquals(me, my.getHolder());
    }

    @Test
    public void setHolder() {
        Holder myMom = new Holder("Carrie", "Zhang");
        Account nowMom = my.setHolder(myMom);
        assertEquals(myMom, nowMom.getHolder());
        assertEquals(mine, nowMom.getAmount());
    }

    @Test
    public void getAmount() {
        assertEquals(mine, my.getAmount());
    }

    @Test
    public void setAmount() {
        Amount richerNow = new Amount(100000, 88);
        Account richerOne = my.setAmount(richerNow);
        assertEquals(me, richerOne.getHolder());
        assertEquals(richerNow, richerOne.getAmount());
    }


    @Test
    public void deposit(){
        Amount depo1 = new Amount(20000, 0);
        Account afterDepo1 = my.deposit(depo1);
        assertEquals(me, afterDepo1.getHolder());
        assertEquals(110000, afterDepo1.getAmount().getDollars());
        assertEquals(99, afterDepo1.getAmount().getCents());
    }

    @Test
    public void withdraw(){
        Amount withdraw1 = new Amount(30000, 0);
        Account afterWithdraw1 = my.withdraw(withdraw1);
        assertEquals(me, afterWithdraw1.getHolder());
        assertEquals(60000, afterWithdraw1.getAmount().getDollars());
        assertEquals(99, afterWithdraw1.getAmount().getCents());
    }

}