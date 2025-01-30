package code;

import java.sql.Timestamp;

public abstract class Transaction implements TransactionInterface{
    private int transactionID;
    private int accountID;
    private double amount;
    private Timestamp transactionDate;

    private TransactionType transactionType;
    public Transaction(int transactionID, int accountID, double amount, Timestamp transactionDate, TransactionType transactionType) {
        this.transactionID = transactionID;
        this.accountID = accountID;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }

    @Override
    public int getTransactionID() {
        return transactionID;
    }

    @Override
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    @Override
    public int getAccountID() {
        return accountID;
    }

    @Override
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    @Override
    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public TransactionType getTransactionType() {
        return transactionType;
    }

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
