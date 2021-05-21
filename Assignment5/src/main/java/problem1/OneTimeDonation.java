package problem1;

import java.time.LocalDate;

/**
 * This class represents a Donation for a single amount, processed on the date that the donation is
 * created.
 * @author Zu Yu Zhang
 */
public class OneTimeDonation extends Donation{

  private static final double DONATION_NOT_MADE_THIS_YEAR = 0.0;

  /**
   * Creates a new instance of single-amount Donation. (When the creation date is provided)
   *
   * @param amount          the amount of donation
   * @param donationCreated the creation date of the donation
   */
  public OneTimeDonation(double amount, LocalDate donationCreated) {
    super(amount, donationCreated);
  }

  /**
   * Creates a new instance of single-amount Donation. (When the creation date is not provided)
   * The system will use the current date.
   *
   * @param amount the amount of donation
   */
  public OneTimeDonation(double amount) {
    super(amount);
    this.donationCreated = LocalDate.now();
  }

  /**
   * This method determines whether a OneTimeDonation has been made on the specified year, and
   * returns the amount of the OneTimeDonation if true; returns 0.0 if false.
   *
   * @param year the year during which we want to check if this OneTimeDonation has took place.
   * @return the amount of OneTimeDonation if it was made during the specified year, and 0.0 if no.
   */
  @Override
  public double getTotalDonationsForYear(int year) {
    if(this.donationCreated.getYear() == year){
      return this.amount;
    }
    return DONATION_NOT_MADE_THIS_YEAR;
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return super.toString() + " "
        + "Donation Date: " + this.donationCreated;
  }

}
