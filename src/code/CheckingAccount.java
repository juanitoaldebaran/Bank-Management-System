package code;

public class CheckingAccount extends Account{

    public CheckingAccount(int accountID, int userID, String accountNumber, double balance) {
        super(accountID, userID, accountNumber, balance, AccountType.CHECKING);
    }
    @Override
    public void deposit(double amount) {
        try {
            setAccountBalance(getAccountBalance() + amount);
            System.out.println("$" + amount + " added to your account balance!");
        } catch (Exception e) {
            System.out.println("Error on adding on your account balance");
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (getAccountBalance() >= amount) {
                setAccountBalance(getAccountBalance() - amount);
                System.out.println("$" + amount + " withdrawn from your account balance");
            } else {
                System.out.println("Not enough balance");
            }
        } catch (Exception e) {
            System.out.println("Error on withdraw account balance");
        }
    }

    @Override
    public String toString() {
            return String.format("[Transaction Type : %s]", getAccountType().toString());
    }

}
