package problem1;

/**
 * This class represents Dinner event provided by the catering company.
 * @author Zu Yu Zhang
 */

public class Dinner {

  private String clientName;
  private int numAttendees;
  private int nonVegetarian;
  private int vegetarian;

  private static final int MIN_ATTENDEES_DINER = 10;
  private static final int MAX_ATTENDEES_DINNER = 50;
  private static final double NON_VEGE_RATIO = 0.8;
  private static final double VEGE_RATIO = 0.2;

  /**
   * Creates a new Dinner event initialized with the client's name and the number of attendees.
   * Restriction: the number of attendees must be between 10 and 50.
   * @param clientName the client's name
   * @param numAttendees the number of attendees
   */
  public Dinner(String clientName, int numAttendees){
    this.clientName = clientName;
    //throws exception of the entered number of attendees do not meet the requirement
    if(this.validNumAttendees(numAttendees)){
      this.numAttendees = numAttendees;
    } else{
      throw new IllegalArgumentException("Number of attendees should be between 10 and 50.");
    }
    //set the number of non-vegetarian entrees to provide
    nonVegetarian = this.nonVegeEntrees(numAttendees);
    //set the number of vegetarian entrees to provide
    vegetarian = this.vegeEntrees(numAttendees);
  }

  /**
   * Helper method to check if the number of attendees entered by user is valid
   * @param numAttendees the number of attendees entered by user
   */
  private boolean validNumAttendees(int numAttendees){
    return (numAttendees >= MIN_ATTENDEES_DINER && numAttendees <= MAX_ATTENDEES_DINNER);
  }

  /**
   * Helper method to set the number of non-vege entrees to provide based on the number of attendees
   * entered by user, which is 80% of the number of attendees rounded up to the nearest whole
   * integer.
   * @param numAttendees the number of attendees
   */
  private int nonVegeEntrees(int numAttendees){
    return (int) Math.round(this.numAttendees * NON_VEGE_RATIO);
  }

  /**
   * Helper method to set the number of vege entrees to provide based on the number of attendees
   * entered by user, which is 20% of the number of attendees rounded up to the nearest whole
   * integer.
   * @param numAttendees the number of attendees
   */
  private int vegeEntrees(int numAttendees){
    return (int) Math.round(this.numAttendees * VEGE_RATIO);
  }

  /**
   * Gets the client's name.
   * @return the client's name
   */
  public String getClientName() {
    return this.clientName;
  }

  /**
   * Gets the number of attendees.
   * @return the number of attendees
   */
  public int getNumAttendees() {
    return this.numAttendees;
  }

  /**
   * Gets the number of non-vegetarian entrees.
   * @return the number of non-vegetarian entrees
   */
  public int getNonVegetarian() {
    return this.nonVegetarian;
  }

  /**
   * Gets the number of vegetarian entrees.
   * @return the number of vegetarian entrees
   */
  public int getVegetarian() {
    return this.vegetarian;
  }

  /**
   * Sets the client's name
   * @param clientName new client's name
   */
  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  /**
   * Sets the number of attendees (only if within valid range)
   * @param numAttendees new number of attendees
   */
  public void setNumAttendees(int numAttendees) {
    if(this.validNumAttendees(numAttendees)){
      this.numAttendees = numAttendees;
      //once the number of attendees has changed, the number of entrees will change as well
      this.nonVegetarian = this.nonVegeEntrees(numAttendees);
      this.vegetarian = this.vegeEntrees(numAttendees);
    }else{
      throw new IllegalArgumentException("Number of attendees should be between 10 and 50.");
    }
  }
}
