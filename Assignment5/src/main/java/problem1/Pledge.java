package problem1;
/**
 * This class represents a Pledge made to the organization promising to donate a given amount in
 * the future.
 * @author Zu Yu Zhang
 */

import java.time.LocalDate;
import java.util.Objects;

public class Pledge extends Donation{

  private static final double PLEDGE_NOT_REALIZED_THIS_YEAR = 0.0;
  /**
   * The date that the donation will occur
   */
  private LocalDate futureDate;

  /**
   * Creates a new instance of Pledge. (When the donation date is not provided).
   *
   * @param amount the amount of donation
   */
  public Pledge(double amount) {
    super(amount);
    this.futureDate = LocalDate.MAX;
  }

  /**
   * Constructs a new Pledge. (When the donation date is pre-specified)
   *
   * @param amount the amount of donation
   * @param futureDate the date on which the donation will occur
   */
  public Pledge(double amount, LocalDate futureDate){
    super(amount);
    this.futureDate = futureDate;
  }

  /**
   * Gets the donation realization date of the pledge
   *
   * @return the donation realization date of the pledge
   */
  public LocalDate getFutureDate() {
    return this.futureDate;
  }

  /**
   * This method allows to set or change the donation date at any time until the donation has
   * occurred. For example, if someone pledges to donate $1000 on 6/1/2020, they may change the date
   * of the donation through 5/30/2020. The new donation date cannot be set in the past - if the
   * donor requests to change the pledge date on 5/30/2020, the new date cannot be before 5/30/2020.
   *
   * @param newFutureDate the desired donation date
   * @throws DonationHasOccurredException when the user attempts to change the donation date of a
   * pledge that has already been processed
   * @throws DonationDateSetToPastException when the user attempts to set the donation date of a
   * pledge to the past
   */
  public void setDonationDate(LocalDate newFutureDate)
      throws DonationDateSetToPastException, DonationHasOccurredException {
    LocalDate currentDate = LocalDate.now();
    if(currentDate.isBefore(this.futureDate)){
      // The new donation date cannot be set to the past
      if(!newFutureDate.isBefore(currentDate)){
        this.futureDate = newFutureDate;
      }else{
        throw new DonationDateSetToPastException();
      }
    }else{
      // The donation has already occurred at this point
      throw new DonationHasOccurredException();
    }
  }

  /**
   * This method determines whether a Pledge occurs during the specified year. If yes, it returns
   * the amount that the pledge promised, and returns 0.0 if false.
   *
   * @param year the year during which we want to check if this Pledge has took place
   * @return the amount of Pledge if it was made during the specified year, and 0.0 if no.
   */
  @Override
  public double getTotalDonationsForYear(int year) {
    if(this.futureDate.getYear() == year){
      return this.amount;
    }
    return PLEDGE_NOT_REALIZED_THIS_YEAR;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pledge)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Pledge pledge = (Pledge) o;
    return futureDate.equals(pledge.futureDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), futureDate);
  }

  @Override
  public String toString() {
    return super.toString() + " "
        + "Will donate on: " + this.futureDate;
  }
}
