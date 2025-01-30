package code;
import java.sql.Timestamp;
import java.util.Date;
public interface TransactionInterface {
    int getTransactionID();
    void setTransactionID(int transactionID);
    int getAccountID();
    void setAccountID(int accountID);
    TransactionType getTransactionType();
    void setTransactionType(TransactionType transactionType);
    Timestamp getTransactionDate();
    void setTransactionDate(Timestamp transactionDate);
    double getAmount();
    void setAmount(double amount);

}
