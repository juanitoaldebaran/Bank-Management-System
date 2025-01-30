package code;

import java.sql.Timestamp;

public class Transfer extends Transaction {
    private int recipientAccountID;

    public Transfer(int transactionID, int accountID, int recipientAccountID, double amount, Timestamp transactionDate) {
        super(transactionID, accountID, amount, transactionDate, TransactionType.TRANSFER);
        this.recipientAccountID = recipientAccountID;
    }

    public int getRecipientAccountID() {
        return recipientAccountID;
    }

    @Override
    public void processTransaction() {
        System.out.printf("Transferring %.2f from Account ID %d to Account ID %d%n",
                getAmount(), getAccountID(), recipientAccountID);
    }

    @Override
    public String toString() {
        return super.toString() + " | Recipient Account: " + recipientAccountID;
    }
}
