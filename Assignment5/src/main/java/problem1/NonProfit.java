package problem1;

import java.util.ArrayList;
import java.util.Objects;
import problem2.Item;

/**
 * This class tracks a non-profit organization's name and the collection of all donations made to
 * this organization.
 *
 * @author Zu Yu Zhang
 */
public class NonProfit implements TotalYearAmount {

  private String orgName;
  private ArrayList<Donation> donations;

  /**
   * Constructs a new NonProfit object initialized with the organization's name and all of its
   * donations received.
   *
   * @param orgName the non-profit organization's name
   * @param donations all the donations the organization has received
   */
  public NonProfit(String orgName, ArrayList<Donation> donations) {
    this.orgName = orgName;
    this.donations = donations;
  }

  /**
   * Gets the non-profit's name
   *
   * @return the non-profit organization's name
   */
  public String getOrgName() {
    return this.orgName;
  }

  /**
   * Gets the list of donations made to the non-profit
   *
   * @return list of all donations made to this non-profit organization
   */
  public ArrayList<Donation> getDonations() {
    return this.donations;
  }

  /**
   * This method returns the sum of all donations processed in the specified year.
   *
   * @param year the year for which we want to calculate the sum of all donations processed
   * @return the sum of all donations processed
   */
  @Override
  public double getTotalDonationsForYear(int year) {
    double yearTotal = 0.0;
    for(Donation eachDonation : this.donations){
      yearTotal += eachDonation.getTotalDonationsForYear(year);
    }
    return yearTotal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NonProfit)) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return getOrgName().equals(nonProfit.getOrgName()) &&
        getDonations().equals(nonProfit.getDonations());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getOrgName(), getDonations());
  }

  @Override
  public String toString() {
    String donationsDescription = "";
    for(Donation donation: this.donations){
      donationsDescription += donation.toString() + "\n";
    }
    return "Organization: " + this.orgName + "\n" +
        donationsDescription;
  }
}
