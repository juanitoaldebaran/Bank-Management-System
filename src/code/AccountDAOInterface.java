package code;

import java.util.List;

public interface AccountDAOInterface {

    void createAccount(Account account);

    List<Account> listAccount();

    Account listAccountByID(int id);
    void updateAccount(Account account);

    void deleteAccount(int accountID);

}
