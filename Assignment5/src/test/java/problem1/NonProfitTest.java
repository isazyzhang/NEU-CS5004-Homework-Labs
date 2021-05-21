package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import jdk.vm.ci.meta.Local;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {
  NonProfit UNICEF;
  NonProfit UNICEF1;
  NonProfit UNICEFAsia;
  NonProfit UNICEFAfrica;
  String UNICEFDescription;
  NonProfit mayoClinic;
  ArrayList<Donation> unicefDonations;
  ArrayList<Donation> mayoClinicDonations;

  OneTimeDonation d1;
  OneTimeDonation d2;
  OneTimeDonation d3;
  OneTimeDonation d4;

  MonthlyDonation m1;
  MonthlyDonation m2;
  MonthlyDonation m3;
  MonthlyDonation m4;

  Pledge p1;
  Pledge p2;
  Pledge p3;
  Pledge p4;

  @Before
  public void setUp() throws Exception {
    d1 = new OneTimeDonation(50.0, LocalDate.of(2018, 2, 2));
    d2 = new OneTimeDonation(100.0, LocalDate.of(2019,9,9));
    d3 = new OneTimeDonation(200.0, LocalDate.of(2020, 1, 1));
    d4 = new OneTimeDonation(500.0, LocalDate.of(2020,1,3));

    m1 = new MonthlyDonation(100.0, LocalDate.of(1999, 10, 10));
    m2 = new MonthlyDonation(100.0, LocalDate.of(2018, 10, 10));
    m2.setCancellation(LocalDate.of(2021,7,7));
    m3 = new MonthlyDonation(500.0, LocalDate.of(2020, 1,1 ));
    m3.setCancellation(LocalDate.of(2020,12,12));
    m4 = new MonthlyDonation(10.0);

    p1 = new Pledge(1000.0);
    p2 = new Pledge(800.0, LocalDate.of(2020, 11, 11));
    p3 = new Pledge(900.0, LocalDate.of(2021, 1, 1));
    p4 = new Pledge(2000.0, LocalDate.of(2020,12,12));

    unicefDonations = new ArrayList<Donation>(Arrays.asList(d1, d3, d4, p2, p3, m3));
    UNICEF = new NonProfit("UNICEF", unicefDonations);
    UNICEFDescription = "Organization: UNICEF\n" +
        "$50.0 Donation Date: 2018-02-02\n" +
        "$200.0 Donation Date: 2020-01-01\n" +
        "$500.0 Donation Date: 2020-01-03\n" +
        "$800.0 Will donate on: 2020-11-11\n" +
        "$900.0 Will donate on: 2021-01-01\n" +
        "$500.0 Date Created: 2020-01-01 Cancellation Date: 2020-12-12\n";

    UNICEF1 = new NonProfit("UNICEF", unicefDonations);
    mayoClinicDonations = new ArrayList<Donation>(Arrays.asList(d2, p1, p4, m1, m2, m4));
    mayoClinic = new NonProfit("Mayo Clinic", mayoClinicDonations);

    UNICEFAsia = new NonProfit("UNICEF Asia", unicefDonations);
    UNICEFAfrica = new NonProfit("UNICEF", mayoClinicDonations);
  }

  @Test
  public void getOrgName() {
    assertEquals("UNICEF", UNICEF.getOrgName());
  }

  @Test
  public void getDonations() {
    assertEquals(unicefDonations, UNICEF.getDonations());
  }

  @Test
  public void getTotalDonationsForYear() {
    assertEquals(7500.0, UNICEF.getTotalDonationsForYear(2020), 0);
  }

  @Test
  public void testEquals() {
    assertTrue(UNICEF.equals(UNICEF));
    assertFalse(UNICEF.equals(null));
    assertFalse(UNICEF.equals(UNICEFDescription));
    assertTrue(UNICEF.equals(UNICEF1));
    assertFalse(UNICEF.equals(mayoClinic));
    assertFalse(UNICEF.equals(UNICEFAsia));
    assertFalse(UNICEF.equals(UNICEFAfrica));
  }

  @Test
  public void testHashCode() {
    assertTrue(UNICEF.hashCode() == UNICEF1.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals(UNICEFDescription, UNICEF.toString());
  }
}