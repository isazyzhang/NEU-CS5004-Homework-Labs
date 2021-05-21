package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LockerTest {
  private Recipient me;
  private Locker locker1;

  @Before
  public void setUp() throws Exception {
    me = new Recipient("Isabella", "Zhang", "isabella@google.com");
    locker1 = new Locker(20, 20, 20);
  }

  @Test
  public void getMail(){
    assertEquals(null, locker1.getMail());
  }

  @Test
  public void addMail()
      throws InvalidDimensionException, MailExceedsLockerDimensionException, LockerOccupiedException {
    locker1.addMail(10, 10, 10, me);
    assertEquals(10, locker1.getMail().getWidth());
    assertEquals(10, locker1.getMail().getHeight());
    assertEquals(10, locker1.getMail().getDepth());
  }


  @Test(expected = LockerOccupiedException.class)
  public void lockerOccupied()
      throws InvalidDimensionException, MailExceedsLockerDimensionException, LockerOccupiedException {
    Recipient jane = new Recipient("Jane", "Smith", "jane@microsoft.com");
    locker1.addMail(10, 10, 10, me);
    locker1.addMail(20, 20, 20, jane);
  }

  @Test(expected = MailExceedsLockerDimensionException.class)
  public void exceedsWidth()
      throws InvalidDimensionException, MailExceedsLockerDimensionException, LockerOccupiedException {
    locker1.addMail(80, 10, 10, me);
  }

  @Test(expected = MailExceedsLockerDimensionException.class)
  public void exceedsHeight()
      throws InvalidDimensionException, MailExceedsLockerDimensionException, LockerOccupiedException {
    locker1.addMail(10, 30, 10, me);
  }

  @Test(expected = MailExceedsLockerDimensionException.class)
  public void exceedsDepth()
      throws InvalidDimensionException, MailExceedsLockerDimensionException, LockerOccupiedException {
    locker1.addMail(10, 10, 100, me);
  }

  @Test
  public void pickupMail()
      throws InvalidDimensionException, MailExceedsLockerDimensionException, LockerOccupiedException, EmptyLockerException, IncorrectRecipientException {
    locker1.addMail(10, 10, 10, me);
    Mail pickedUp = locker1.pickupMail(me);
    assertEquals(10, pickedUp.getWidth());
    assertEquals(10, pickedUp.getHeight());
    assertEquals(10, pickedUp.getDepth());
    assertEquals(null, locker1.getMail());

  }

  @Test(expected = EmptyLockerException.class)
  public void emptyLocker()
      throws EmptyLockerException, InvalidDimensionException, IncorrectRecipientException {
    locker1.pickupMail(me);
  }

  @Test(expected = IncorrectRecipientException.class)
  public void incorrectRecipient()
      throws EmptyLockerException, InvalidDimensionException, IncorrectRecipientException, LockerOccupiedException, MailExceedsLockerDimensionException {
    locker1.addMail(10, 10, 10, me);
    Recipient phoebe = new Recipient("Phoebe", "Bee", "phoebe@citi.com");
    locker1.pickupMail(phoebe);
  }

}