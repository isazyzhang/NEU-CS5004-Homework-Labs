package problem1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.CancellationException;

/**
 * This class represents a monthly Donation made to a non-profit organization.
 * @author Zu Yu Zhang
 */
public class MonthlyDonation extends Donation{

  /**
   * The monthly donation's cancellation date
   */
  private LocalDate cancelDate;
  private static final double NO_TOTAL_FOR_THIS_YEAR = 0.0;
  private static final int MONTHS_IN_YEAR = 12;
  private static final int JANUARY = 1;
  private static final int FIRST_OF_JAN = 1;
  private static final int DECEMBER = 12;
  private static final int THIRTY_FIRST = 31;
  private static final int ADJUSTMENT = 1;

  /**
   * Creates a new instance of monthly Donation. (When the creation date is provided)
   *
   * @param amount          the amount of donation
   * @param donationCreated the creation date of the donation
   */
  public MonthlyDonation(double amount, LocalDate donationCreated) {
    super(amount, donationCreated);
    this.cancelDate = LocalDate.MAX;
  }

  /**
   * Creates a new instance of monthly Donation. (When the creation date is not provided)
   * The system will use the current date.
   *
   * @param amount the amount of donation
   */
  public MonthlyDonation(double amount) {
    super(amount);
    this.donationCreated = LocalDate.now();
    this.cancelDate = LocalDate.MAX;
  }


  /**
   * Gets the cancellation date of the monthly Donation.
   *
   * @return the monthly donation's cancellation date
   */
  public LocalDate getCancelDate() {
    return this.cancelDate;
  }


  /**
   * This method sets a cancellation date.
   * Should ensure that the proposed cancellation date is not in the past.
   *
   * @param cancelDate the Donation's cancellation date
   * @throws CancelDateInThePastException when user attempts to set the cancellation date to the
   * past
   */
  public void setCancellation(LocalDate cancelDate) throws CancelDateInThePastException {
    // Exception is thrown if the proposed cancellation date is set to the past
    if(cancelDate.isBefore(LocalDate.now())){
      throw new CancelDateInThePastException();
    }
    this.cancelDate = cancelDate;
  }

  /**
   * This method calculates the total generated by a monthly donation during a given year.
   *
   * @param year the year during which we want to calculate the total amount generated by a monthly
   *             donation
   * @return the total accumulated by this monthly donation during the specified year
   */
  @Override
  public double getTotalDonationsForYear(int year) {
    // If the donation year was before this year
    if (this.donationCreated.getYear() < year) {
      // If the cancellation date is after this year, calculate the yearly total
      // as 12 * monthly donation amount
      if (this.cancelDate.getYear() > year) {
        return this.amount * MONTHS_IN_YEAR;
      } else if (this.cancelDate.getYear() == year) {
        // If the cancellation date is during this year, calculate the total accumulated from
        // from January up to the cancellation month
        LocalDate januaryFirst = LocalDate.of(year, JANUARY, FIRST_OF_JAN);
        int transactions1 = (int) (januaryFirst.until(this.cancelDate, ChronoUnit.MONTHS) + ADJUSTMENT);
        return this.amount * transactions1;
      } else {
        return NO_TOTAL_FOR_THIS_YEAR;
      }
    } else if (this.donationCreated.getYear() == year) {  // If the donation was created on this year
      if (this.cancelDate.getYear() > year) {
        // If the cancellation date is not this year, total accumulated during this year should be
        // the donation amount * (number of months between the creation date and december + 1)
        LocalDate december31st = LocalDate.of(year, DECEMBER, THIRTY_FIRST);
        int transaction2 = (int) (this.donationCreated.until(december31st, ChronoUnit.MONTHS) + ADJUSTMENT);
        return this.amount * transaction2;
      } else {
        // If the donation will be cancelled during this same year, total accumulated should be
        // the donation amount * number of months between the cancellation date and the creation date
        return this.amount * (this.donationCreated.until(this.cancelDate, ChronoUnit.MONTHS)+ ADJUSTMENT);
      }
    } else {
      return NO_TOTAL_FOR_THIS_YEAR;
    }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MonthlyDonation)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return getCancelDate().equals(that.getCancelDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCancelDate());
  }

  @Override
  public String toString() {
    return super.toString() + " "
        + "Date Created: " + this.donationCreated + " "
        + "Cancellation Date: " + this.cancelDate;
  }

}
