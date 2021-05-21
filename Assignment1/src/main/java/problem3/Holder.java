package problem3;

/**
 * This class represents an account holder with his/her details: first name and last name.
 * @author Zu Yu Zhang
 */

public class Holder {

    private String firstName;
    private String lastName;

    /**
     * Creates a new Holder object and initializes it with the given first name and last name.
     * @param firstName first name of the account holder
     * @param lastName last name of the account holder
     */
    public Holder(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the holder
     * @return holder's first name
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Gets the last name of the holder.
     * @return holder's last name
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Creates a new Holder with a different first name but the same last name.
     * @param firstName the new first name
     * @return A new Holder object
     */
    public Holder changeFirstName(String firstName){
        return new Holder(firstName, this.lastName);
    }

    /**
     * Creates a new Holder with a different last name but the same first name.
     * @param lastName the new last name
     * @return A new Holder object
     */
    public Holder changeLastName(String lastName){
        return new Holder(this.firstName, lastName);
    }
}
