
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private String pin;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, String accountHolder,
                   String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public boolean verifyPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount));
        return true;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
