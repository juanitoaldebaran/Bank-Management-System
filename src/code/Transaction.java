package code;

import java.sql.Timestamp;

public abstract class Transaction implements TransactionInterface{
    private int transactionID;
    private int accountID;
    private double amount;

    private String recipientAccount;
    private Timestamp transactionDate;

    private TransactionType transactionType;
    public Transaction(int transactionID, int accountID, double amount, String recipientAccount, Timestamp transactionDate, TransactionType transactionType) {
        this.transactionID = transactionID;
        this.accountID = accountID;
        this.amount = amount;
        this.recipientAccount = recipientAccount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }

    //Getter
    @Override
    public int getTransactionID() {
        return transactionID;
    }

    //Setter
    @Override
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    //Getter
    @Override
    public int getAccountID() {
        return accountID;
    }

    //Setter
    @Override
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    //Getter
    @Override
    public double getAmount() {
        return amount;
    }

    //Setter
    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    //Getter
    @Override
    public String getRecipientAccount() {
        return recipientAccount;
    }

    //Setter
    @Override
    public void setRecipientAccount() {
        this.recipientAccount = recipientAccount;
    }

    //Getter
    @Override
    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    //Setter
    @Override
    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    //Getter
    @Override
    public TransactionType getTransactionType() {
        return transactionType;
    }

    //Setter
    @Override
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public abstract void processTransaction();

    @Override
    public String toString() {
        return String.format("Transaction ID: %d | Account ID: %d | Amount: %.2f | Date: %s",
                transactionID, accountID, amount, transactionDate);
    }
}
