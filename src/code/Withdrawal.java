package code;

import java.sql.Timestamp;

public class Withdrawal extends Transaction {

    public Withdrawal(int transactionID, int accountID, double amount, Timestamp transactionDate) {
        super(transactionID, accountID, amount, transactionDate, TransactionType.WITHDRAW);
    }

    @Override
    public void processTransaction() {
        System.out.printf("Withdrawing %.2f from Account ID %d%n", getAmount(), getAccountID());
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: WITHDRAWAL";
    }
}
