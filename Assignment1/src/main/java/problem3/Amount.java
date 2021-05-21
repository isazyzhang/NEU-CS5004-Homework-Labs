package problem3;

/**
 * This class represents an Amount object with the following details: dollar amount and cents amount.
 * @author Zu Yu Zhang
 */

public class Amount {

    private int dollars;
    private int cents;
    private static final int MIN = 0;
    private static final int MAX_CENTS = 99;
    private static final int CENTS_IN_DOLLAR = 100;

    /**
     * Creates a new Amount object with a dollar amount and a cents amount.
     * Restrictions: dollar amount must be greater than or equal to 0, cents amount must be between 0 and 99 inclusive.
     * @param dollars the dollar amount
     * @param cents the cents amount
     */
    public Amount(int dollars, int cents){
        if(dollars >= MIN){
            this.dollars = dollars;
        }else{
            throw new IllegalArgumentException("Dollar amount must be greater than or equal to 0");
        }

        if(cents >= MIN && cents <= MAX_CENTS){
            this.cents = cents;
        }else{
            throw new IllegalArgumentException("Cents amount must be between 0 and 99 inclusive");
        }
    }

    /**
     * Get the number of dollars.
     * @return number of dollars
     */
    public int getDollars(){
        return this.dollars;
    }

    /**
     * Get the number of cents.
     * @return number of cents
     */
    public int getCents(){
        return this.cents;
    }

    /**
     *  Creates a new Amount object with the same number of cents but different number of dollars.
     * @param dollars the new number of dollars
     * @return A new Amount object
     */
    public Amount changeDollars(int dollars){
        return new Amount(dollars, this.cents);
    }

    /**
     * Creates a new Amount object with the same number of dollars but different number of cents.
     * @param cents the new number of cents
     * @return A new Amount object
     */
    public Amount changeCents(int cents){
        return new Amount(this.dollars, cents);
    }

    /**
     * Converts a balance represented by an Amount object to number of cents.
     * @return the number of cents
     */
    public int convertToCents(){
        int totalCents = this.dollars * CENTS_IN_DOLLAR + this.cents;
        return totalCents;
    }

    /**
     * Represents a number of cents as an Amount object.
     * @param totalCents the number of cents to be converted
     * @return the Amount object
     */
    public static Amount convertToAmount(int totalCents){
        int dollars = totalCents / CENTS_IN_DOLLAR;
        int cents = totalCents % CENTS_IN_DOLLAR;
        return new Amount(dollars, cents);
    }

    /**
     * Helper method for handling a deposit: update the value of the Amount after a deposit has been made.
     * @param into amount of money that was deposited
     * @return new balance after depositing
     */
    public Amount addingToBalance(Amount into){
        int centsAfterDeposit = this.convertToCents() + into.convertToCents();
        Amount afterDeposit = Amount.convertToAmount(centsAfterDeposit);
        return afterDeposit;
    }

    /**
     * Helper method for handling a withdrawal: update the value of the Amount after a withdrawal has been made.
     * @param outOf amount of money that was withdrawn
     * @return new balance after withdrawing
     */
    public Amount removingFromBalance(Amount outOf){
        int centsAfterWithdrawal = this.convertToCents() - outOf.convertToCents();
        Amount afterWithdrawal = Amount.convertToAmount(centsAfterWithdrawal);
        return afterWithdrawal;
    }

}
