package code;

import java.util.List;

public interface TransactionDAOInterface {
    void createTransaction(Transaction transaction);
    List<Transaction> listTransactions();
    Transaction listTransactionsByID(int id);
    void updateTransactions(Transaction transaction);
    void deleteTransactions(int id);
}
