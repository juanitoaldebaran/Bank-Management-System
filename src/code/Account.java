package code;

public abstract class Account implements AccountInterface{
    private int accountID;
    private int userID;

    private String accountNumber;
    private double balance;
    private AccountType type;

    public Account(int accountID, int userID, String accountNumber, double balance, AccountType type) {
        this.accountID = accountID;
        this.userID = userID;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    //Getter
    @Override
    public int getAccountID() {
        return accountID;
    }

    //Setter
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    //Getter
    @Override
    public int getUserID() {
        return userID;
    }

    //Setter
    public void setUserID(int userID) {
        this.userID = userID;
    }

    //Getter
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    //Setter
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //Getter
    @Override
    public double getAccountBalance() {
        return balance;
    }

    //Setter
    public void setAccountBalance(double balance) {
        this.balance = balance;
    }

    //Getter
    @Override
    public AccountType getAccountType() {
        return type;
    }

    //Setter
    public void setAccountType(AccountType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Account [ ID : %d | UserID : %d | AccountNumber : %s | Balance : $%.2f | Account Type : %s ]", getAccountID(), getUserID(), getAccountNumber(), getAccountBalance(), getAccountType());
    }

}
