package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankDAO implements UsersDAOInterface, AccountDAOInterface, TransactionInterface{

    private final Connection connection;

    public BankDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createUsers(Users users) {
        String createQuery = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(createQuery)) {
            statement.setString(1, users.getName());
            statement.setString(2, users.getEmail());
            statement.setString(3, users.getPassword());

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " rows affected");
        } catch (SQLException e) {
            System.out.println("Failed to create users into database");
            e.printStackTrace();
        }
    }

    @Override
    public List<Users> listUsers() {
        String listQuery = "SELECT * FROM users";
        List<Users> usersList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(listQuery)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    usersList.add( new Users(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("password")
                            )
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to list users into database");
            e.printStackTrace();
        }

        return usersList;
    }

    @Override
    public Users listUsersByID(int ID) {
        String listIDQuery = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(listIDQuery)) {
            statement.setInt(1, ID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Users(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to list users by ID into database");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateUsers(int ID, String name, String email, String password) {
        String updateQuery = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setInt(4, ID);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " rows affected");
            } else {
                System.out.println("No users with ID " + ID);
            }
        } catch (SQLException e) {
            System.out.println("Failed to update users by ID into database");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUsers(int ID) {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, ID);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " rows affected");
            } else {
             System.out.println("No users found with ID " + ID);
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete users by ID");
            e.printStackTrace();
        }
    }

    @Override
    public void createAccount(Account account) {
        String createAccountQuery = "INSERT INTO accounts (user_id, account_number, balance, type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(createAccountQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, account.getUserID());
            statement.setString(2, account.getAccountNumber());
            statement.setDouble(3, account.getAccountBalance());
            statement.setString(4, account.getAccountType().toString());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        account.setAccountID(generatedKeys.getInt(1));
                    }
                }
            }
            System.out.println(rowsAffected + " rows affected");
        } catch (SQLException e) {
            System.out.println("Failed to create an account into database");
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> listAccount(){
        String listAccountQuery = "SELECT * FROM accounts";
        List<Account> accountList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(listAccountQuery)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    AccountType type = AccountType.valueOf(resultSet.getString("type"));
                    if (type == AccountType.SAVINGS) {
                        accountList.add(new SavingsAccount (
                                resultSet.getInt("id"),
                                resultSet.getInt("user_id"),
                                resultSet.getString("account_number"),
                                resultSet.getDouble("balance")
                        ));
                    } else if (type == AccountType.CHECKING) {
                        accountList.add(new CheckingAccount(
                               resultSet.getInt("id"),
                               resultSet.getInt("user_id"),
                               resultSet.getString("account_number"),
                               resultSet.getDouble("balance")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to list account into database");
            e.printStackTrace();
        }

        return accountList;
    }

    @Override
    public Account listAccountByID(int ID) {
        String listAccountIDQuery = "SELECT * FROM accounts WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(listAccountIDQuery)) {
            statement.setInt(1, ID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    AccountType type = AccountType.valueOf(resultSet.getString("type"));
                    if (type == AccountType.CHECKING) {
                        return new CheckingAccount(
                                resultSet.getInt("id"),
                                resultSet.getInt("user_id"),
                                resultSet.getString("account_number"),
                                resultSet.getDouble("balance")
                        );
                    } else if (type == AccountType.SAVINGS) {
                        return new SavingsAccount(
                                resultSet.getInt("id"),
                                resultSet.getInt("user_id"),
                                resultSet.getString("account_number"),
                                resultSet.getDouble("balance")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to list account by ID into database");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateAccount(Account account) {
        String updateAccountQuery = "UPDATE accounts SET user_id = ?, account_number = ?, balance = ?, type = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateAccountQuery)) {
                    statement.setInt(1, account.getUserID());
                    statement.setString(2, account.getAccountNumber());
                    statement.setDouble(3, account.getAccountBalance());
                    statement.setString(4, account.getAccountType().toString());
                    statement.setInt(5, account.getAccountID());

                    int rowsAffected = statement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Successfully update users from database");
                    } else {
                        System.out.println("Failed to update users from database");
                    }
        } catch (SQLException e) {
            System.out.println("Failed to update an account into database");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(int id) {
        String deleteAccountQuery = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteAccountQuery)) {
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully delete users from database");
            } else {
                System.out.println("Failed to delete users from database");
            }
        }catch (SQLException e) {
            System.out.println("Failed to delete an account into database");
            e.printStackTrace();
        }
    }

    @Override
    public void createTransaction(Transaction transaction) {
        String createTransactionQuery = "INSERT INTO transactions (account_id, type, amount, recipient_account, transaction_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(createTransactionQuery)) {
            statement.setInt(1, transaction.getTransactionID());
            statement.setString(2, TransactionType.valueOf(transaction.getTransactionType().toString());
            statement.setDouble(3, transaction.getAmount());
            statement.setString(4, transaction.getRecipientAccount());
            statement.setTimestamp(5, transaction.getTransactionDate());

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0) {
                System.out.println("Successfully create a transaction into database");
            } else {
                System.out.println("Failed to create transaction into database");
            }
        } catch (SQLException e) {
            System.out.println("Failed to create a transactions into database");
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> listTransaction() {
    }
}
