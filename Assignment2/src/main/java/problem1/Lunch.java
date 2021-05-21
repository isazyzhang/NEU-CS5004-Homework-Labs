package problem1;

/**
 * This class represents a Lunch event provided by the catering company.
 * @author  Zu Yu Zhang
 */

public class Lunch {
  private String clientName;
  private int numAttendees;
  private int numSandwiches;

  private static final int MIN_ATTENDEES_LUNCH = 15;
  private static final int MAX_ATTENDEES_LUNCH = 90;
  private static final double SANDWICH_RATIO = 1.05;

  /**
   * Creates a new Lunch event initialized with the client's name and the number of attendees.
   * Restriction: the number of attendees must be between 15 and 90
   * @param clientName the client's name
   * @param numAttendees the number of attendees
   */
  public Lunch(String clientName, int numAttendees){
    this.clientName = clientName;
    //throws exception of the entered number of attendees do not meet the requirement
    if(this.validNumAttendees(numAttendees)){
      this.numAttendees = numAttendees;
    } else{
      throw new IllegalArgumentException("Number of attendees should be between 15 and 90.");
    }
    //set the number of sandwiches to provide
    this.numSandwiches = this.howManySandwiches(numAttendees);
  }

  /**
   * Helper method to check if the number of attendees entered by user is valid
   * @param numAttendees the number of attendees entered by user
   */
  private boolean validNumAttendees(int numAttendees){
    return (numAttendees >= MIN_ATTENDEES_LUNCH && numAttendees <= MAX_ATTENDEES_LUNCH);
  }

  /**
   * Helper method to set the number of sandwiches to provide based on the number of attendees
   * entered by user, which is 1.05 times the number of attendees rounded to the nearest whole
   * integer.
   * @param numAttendees the number of attendees
   */
  private int howManySandwiches(int numAttendees){
    return (int) Math.round(this.numAttendees * SANDWICH_RATIO);
  }

  /**
   * Gets the client's name
   * @return the client's name
   */
  public String getClientName() {
    return this.clientName;
  }

  /**
   * Sets the client's name
   * @param clientName new client's name
   */
  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  /**
   * Gets the number of attendees
   * @return the number of attendees
   */
  public int getNumAttendees() {
    return this.numAttendees;
  }

  /**
   * Sets the number of attendees (only if the number is valid)
   * @param numAttendees the new number of attendees
   */
  public void setNumAttendees(int numAttendees) {
    if(this.validNumAttendees(numAttendees)) {
      this.numAttendees = numAttendees;
      //once the number of attendees has changed, the number of sandwiches changes accordingly
      this.numSandwiches = this.howManySandwiches(numAttendees);
    }else{
      throw new IllegalArgumentException("Number of attendees should be between 15 and 90.");
    }
  }

  /**
   * Gets the number of sandwiches provided.
   * @return the number of sandwiches
   */
  public int getNumSandwiches(){
    return this.numSandwiches;
  }
}
