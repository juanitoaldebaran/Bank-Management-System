package code;

public class SavingsAccount extends Account {

        public SavingsAccount(int accountID, int userID, String accountNumber, double balance, AccountType type) {
        super(accountID, userID, accountNumber, balance, type.SAVINGS);
    }

    @Override
    public void deposit(double amount) {
        setAccountBalance(getAccountBalance() + amount);
        System.out.println("$" + amount + " added to the balance");
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (getAccountBalance() >= amount) {
                setAccountBalance(getAccountBalance() - amount);
                System.out.println("$" + amount + " withdrawn to the balance");
            } else {
                System.out.println("Not enough balance");
            }
        } catch (Exception e) {
            System.out.println("Error on withdraw balance");
        }
    }

    @Override
    public String toString() {
            return String.format("[Transaction Type : %s]", getAccountType().toString());
    }


}
