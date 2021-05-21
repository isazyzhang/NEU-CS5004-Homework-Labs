package problem1;

/**
 * This is an interface that all classes inheriting the Donation class will implement.
 */
public interface TotalYearAmount {

  /**
   * This method returns the sum of all donations processed in the specified year.
   *
   * @param year the year for which we want to calculate the total amount of donations
   * @return the total amount of donations received during the specified year
   */
  public double getTotalDonationsForYear(int year);

}
