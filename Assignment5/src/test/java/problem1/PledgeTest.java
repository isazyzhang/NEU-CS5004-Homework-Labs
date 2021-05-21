package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;

public class PledgeTest {
  Pledge promised;
  LocalDate promisedDate;
  String description1;
  Pledge notPromised;
  Pledge occurred;
  LocalDate occurredDate;
  Pledge promised2;
  Pledge promised3;
  Pledge promised4;

  @Before
  public void setUp() throws Exception {
    promisedDate = LocalDate.of(2021, 6, 7);
    promised = new Pledge(1000.5, promisedDate);
    promised2 = new Pledge(9000.99, promisedDate);
    promised3 = new Pledge(1000.5, LocalDate.of(2023, 9, 8));
    description1 = "$1000.5 Will donate on: 2021-06-07";
    notPromised = new Pledge(2000.0);
    occurredDate = LocalDate.of(2020, 1, 31);
    occurred = new Pledge(3000.7, occurredDate);
    promised4 = new Pledge(1000.5, promisedDate);
  }

  @Test
  public void testGetAmount(){
    assertEquals(3000.7, occurred.getAmount(), 0);
  }

  @Test
  public void testGetFutureDate(){
    assertEquals(LocalDate.of(2020, 1, 31), occurred.getFutureDate());
  }

  @Test
  public void setDonationDate()
      throws DonationHasOccurredException, DonationDateSetToPastException {
    notPromised.setDonationDate(LocalDate.of(2020, 9, 9));
  }

  @Test(expected = DonationDateSetToPastException.class)
  public void setDonationDate1()
      throws DonationHasOccurredException, DonationDateSetToPastException {
    promised.setDonationDate(LocalDate.of(1990, 2, 2));
  }

  @Test(expected = DonationHasOccurredException.class)
  public void setDonationDate2()
      throws DonationHasOccurredException, DonationDateSetToPastException {
    occurred.setDonationDate(LocalDate.of(2022, 7, 28));
  }

  @Test
  public void getTotalDonationsForYear() {
    assertEquals(1000.5, promised.getTotalDonationsForYear(2021), 0);
    assertEquals(0.0, notPromised.getTotalDonationsForYear(2000), 0);
  }

  @Test
  public void testEquals() {
    assertTrue(promised.equals(promised));
    assertFalse(promised.equals(null));
    assertFalse(promised.equals(description1));
    assertFalse(promised.equals(notPromised));
    assertFalse(promised.equals(promised2));
    assertFalse(promised.equals(promised3));
    assertTrue(promised.equals(promised4));
  }

  @Test
  public void testHashCode() {
    assertTrue(promised.hashCode() == promised4.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(description1, promised.toString());
  }
}