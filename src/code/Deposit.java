package code;

import java.sql.Timestamp;

public class Deposit extends Transaction{
    public Deposit(int transactionID, int accountID, double amount, Timestamp transactionDate) {
        super(transactionID, accountID, amount, transactionDate, TransactionType.DEPOSIT);
    }

    @Override
    public void processTransaction() {
        System.out.printf("Deposit %.2f from Account ID %d%n", getAmount(), getAccountID());
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Deposit";
    }
}
