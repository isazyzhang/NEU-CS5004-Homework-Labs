package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;

public class MonthlyDonationTest {
  MonthlyDonation donation1;
  MonthlyDonation donation2;
  MonthlyDonation donation3;
  MonthlyDonation donation4;
  MonthlyDonation donation5;
  MonthlyDonation donation6;
  String d1Description;

  @Before
  public void setUp() throws Exception {
    donation1 = new MonthlyDonation(100.0, LocalDate.of(2011, 11, 11));
    d1Description = "$100.0 Date Created: 2011-11-11 Cancellation Date: +999999999-12-31";
    donation2 = new MonthlyDonation(100.0, LocalDate.of(2020, 9, 9));
    donation3 = new MonthlyDonation(100.0, LocalDate.of(2020, 9, 9));
    donation2.setCancellation(LocalDate.of(2022,7,7));
    donation3.setCancellation(LocalDate.of(2022,8,8));
    donation4 = new MonthlyDonation(100.0, LocalDate.of(2011,11,11));
    donation5 = new MonthlyDonation(1200.0);
    donation6 = new MonthlyDonation(1500.0);

  }

  @Test
  public void testGetAmount(){
    assertEquals(100.0, donation1.getAmount(), 0);
  }

  @Test
  public void testGetCreationDate(){
    assertEquals(LocalDate.of(2011, 11, 11), donation1.getDonationCreated());
  }

  @Test(expected = CancelDateInThePastException.class)
  public void setCancellation() throws CancelDateInThePastException {
    donation1.setCancellation(LocalDate.of(2023, 3, 3));
    donation1.setCancellation(LocalDate.of(2020,1,1));
  }

  @Test
  public void getCancelDate() throws CancelDateInThePastException {
    donation1.setCancellation(LocalDate.of(2023, 3, 3));
    assertTrue(LocalDate.of(2023, 3, 3).equals(donation1.getCancelDate()));
  }

  @Test
  public void getTotalDonationsForYear() throws CancelDateInThePastException {
    MonthlyDonation donation2 = new MonthlyDonation(100.0, LocalDate.of(2020, 1, 15));
    assertEquals(0.0, donation2.getTotalDonationsForYear(2012),0);
    assertEquals(1200.0, donation2.getTotalDonationsForYear(2021),0);
    MonthlyDonation donation5 = new MonthlyDonation(100.0, LocalDate.of(2018, 1, 17));
    donation5.setCancellation(LocalDate.of(2020, 7, 25));
    assertEquals(700.0, donation5.getTotalDonationsForYear(2020), 0);
    assertEquals(0.0, donation5.getTotalDonationsForYear(2080), 0);

    MonthlyDonation donation3 = new MonthlyDonation(200.0, LocalDate.of(2020, 3, 17));
    donation3.setCancellation(LocalDate.of(2021, 5, 18));
    assertEquals(2000.0, donation3.getTotalDonationsForYear(2020),0);
    MonthlyDonation donation4 = new MonthlyDonation(100.0, LocalDate.of(2020, 8, 12));
    donation4.setCancellation(LocalDate.of(2020,11,29));
    assertEquals(400.0, donation4.getTotalDonationsForYear(2020),0);
  }

  @Test
  public void testEquals() {
    assertTrue(donation1.equals(donation1));
    assertFalse(donation1.equals(null));
    assertFalse(donation1.equals(d1Description));
    assertFalse(donation2.equals(donation3));
    assertTrue(donation1.equals(donation4));
    assertFalse(donation5.equals(donation6));
  }

  @Test
  public void testHashCode() {
    assertTrue(donation1.hashCode() == donation4.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(d1Description, donation1.toString());
  }
}