package problem3;

/**
 * This class represents a back Account with the following information: holder and balance.
 * @author Zu Yu Zhang
 */
public class Account {

    private Holder holder;
    private Amount amount;

    /**
     * Creates a new Account object with holder and account balance details.
     * @param holder the Account's holder
     * @param amount the Account's balance
     */
    public Account(Holder holder, Amount amount){
        this.holder = holder;
        this.amount = amount;
    }

    /**
     * Gets the Holder of the Account.
     * @return Account's Holder
     */
    public Holder getHolder() {
        return holder;
    }

    /**
     * Creates a new Account object with a different holder, but the same account balance.
     * @param holder new holder of account
     * @return new Account object
     */
    public Account setHolder(Holder holder) {
        return new Account(holder, this.amount);
    }

    /**
     * Gets the balance of the Account.
     * @return the Account's balance
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Creates a new Account object with the same holder, but a different balance amount.
     * @param amount new amount of Account
     * @return new Account object
     */
    public Account setAmount(Amount amount) {
        return new Account(this.holder, amount);
    }


    /**
     * Handles a deposit event; money is added to the account balance.
     * @param amount amount to be deposited into the Account
     * @return new Account object with its amount attribute updated
     */
    public Account deposit(Amount amount){
        Amount updatedDeposit = this.amount.addingToBalance(amount);
        return new Account(this.holder, updatedDeposit);
    }


    /**
     * Handles a withdraw event; money is withdrawn from the account balance.
     * @param amount amount to be withdrawn from the Account
     * @return new Account object with its amount attribute updated
     */
    public Account withdraw(Amount amount){
        Amount afterWithdrawal = this.amount.removingFromBalance(amount);
        return new Account(this.holder, afterWithdrawal);
    }


}
