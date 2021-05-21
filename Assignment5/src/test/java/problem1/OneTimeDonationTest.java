package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;

public class OneTimeDonationTest {
  OneTimeDonation donation1;
  LocalDate date1;
  String description1;
  OneTimeDonation donation2;
  OneTimeDonation donation3;
  LocalDate date2;
  OneTimeDonation donation4;
  OneTimeDonation donation5;
  String description5;

  @Before
  public void setUp() throws Exception {
    date1 = LocalDate.of(2020, 2, 5);
    date2 = LocalDate.of(2020, 2, 3);
    donation1 = new OneTimeDonation(100.0, date1);
    description1 = "$100.0 Donation Date: 2020-02-05";
    donation2 = new OneTimeDonation(200.0, date1);
    donation3 = new OneTimeDonation(100.0, date2);
    donation4 = new OneTimeDonation(100.0, date1);
    donation5 = new OneTimeDonation(100.0);
    description5 = "$100.0 Donation Date: 2020-02-11";

  }

  @Test
  public void testGetAmount(){
    assertEquals(100.0, donation1.getAmount(), 0);
  }

  @Test
  public void testGetCreationDate(){
    assertEquals(LocalDate.of(2020, 2, 5), donation1.getDonationCreated());
  }

  @Test
  public void testEquals() {
    assertTrue(donation1.equals(donation1));
    assertFalse(donation1.equals(null));
    assertFalse(donation1.equals(description1));
    assertFalse(donation1.equals(donation2));
    assertFalse(donation1.equals(donation3));
    assertTrue(donation1.equals(donation4));
  }

  @Test
  public void testHashCode() {
    assertTrue(donation1.hashCode() == donation4.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(description1, donation1.toString());
    assertEquals(description5, donation5.toString());
  }

  @Test
  public void getTotalDonationsForYear() {
    assertEquals(100.0, donation1.getTotalDonationsForYear(2020), 0);
    assertEquals(0.0, donation1.getTotalDonationsForYear(1999), 0);
  }
}