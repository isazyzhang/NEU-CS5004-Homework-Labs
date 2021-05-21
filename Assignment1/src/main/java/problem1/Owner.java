package problem1;

/**
 * This class represents the owner of a Vehicle with details -- first name, last name, and a phone number.
 * @author Zu Yu Zhang
 */

public class Owner {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    /**
     * Creates a new Owner object with the following details: first and last names, phone number.
     * @param firstName first name of Owner
     * @param lastName last name of Owner
     * @param phoneNumber phone number of Owner
     */
    public Owner(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        if(this.validNumber(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else{
            throw new IllegalArgumentException("Phone number must consist of ten characters.");
        }
    }

    /**
     * Helper method that ensures that the phone number entered is valid.
     * @return whether the phone number is a valid one or not
     */
    private boolean validNumber(String phoneNumber){
        int validLength = 10;
        return (phoneNumber.length() == validLength);
    }

    /**
     * Returns the first name of the Owner.
     * @return first name of Owner
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the Owner.
     * @return last name of Owner
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the phone number of the Owner.
     * @return phone number of the Owner
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets this owner's first name
     * @param firstName the new first name
     */
    public void changeFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Sets the owner's last name
     * @param lastName the new last name
     */
    public void changeLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Sets the owner's phone number
     * @param phoneNumber the new phone number
     */
    public void changePhoneNumber(String phoneNumber){
        if(this.validNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }else{
            throw new IllegalArgumentException("Phone number must consist of ten characters.");
        }
    }

}
