package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class represents a Donation made to the non-profit organization.
 * @author Zu Yu Zhang
 */
public abstract class Donation implements TotalYearAmount {

  /**
   * The amount of donation
   */
  protected double amount;
  /**
   * The date that the donation was created
   */
  protected LocalDate donationCreated;

  /**
   * Creates a new instance of Donation. (When the creation date is provided)
   *
   * @param amount the amount of donation
   * @param donationCreated the creation date of the donation
   */
  public Donation(double amount, LocalDate donationCreated){
    this.amount = amount;
    this.donationCreated = donationCreated;
  }

  /**
   * Creates a new instance of Donation. (When the creation date is not provided)
   * The system will use the current date.
   *
   * @param amount the amount of donation
   */
  public Donation(double amount){
    this.amount = amount;
    this.donationCreated = LocalDate.now();
  }

  /**
   * Gets the amount of the donation
   *
   * @return the amount of the donation
   */
  public double getAmount() {
    return this.amount;
  }

  /**
   * Gets the creation date of the donation
   *
   * @return the donation's creation date
   */
  public LocalDate getDonationCreated() {
    return this.donationCreated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Donation)) {
      return false;
    }
    Donation donation = (Donation) o;
    return Double.compare(donation.amount, amount) == 0 &&
        donationCreated.equals(donation.donationCreated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, donationCreated);
  }

  @Override
  public String toString() {
    return "$" + amount;
  }
}
