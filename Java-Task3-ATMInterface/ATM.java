
import java.util.List;
import java.util.Scanner;

public class ATM {
    private Scanner scanner;
    private Bank bank;
    private Account account;

    public ATM() {
        scanner = new Scanner(System.in);
        bank = new Bank();
    }

    public void start() {
        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            String enteredPin = scanner.nextLine().trim();

            account = bank.authenticate(enteredPin);

            if (account != null) {
                System.out.println("\nLogin successful!");
                System.out.println("Welcome, " + account.getAccountHolder());
                showMenu();
                return;
            }

            attempts++;
            System.out.println("Incorrect PIN. Attempts left: "
                    + (3 - attempts));
        }

        System.out.println("Too many incorrect attempts. Exiting ATM.");
    }

    private void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.println("==============================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    depositMoney();
                    break;

                case 4:
                    showTransactionHistory();
                    break;

                case 5:
                    showAccountDetails();
                    break;

                case 6:
                    System.out.println("Thank you for using our ATM!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Select 1 to 6.");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Available balance: Rs. %.2f%n",
                account.getBalance());
    }

    private void withdrawMoney() {
        double amount = readAmount("Enter withdrawal amount: Rs. ");

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (account.withdraw(amount)) {
            System.out.println("Please collect your cash.");
            checkBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void depositMoney() {
        double amount = readAmount("Enter deposit amount: Rs. ");

        if (account.deposit(amount)) {
            System.out.println("Money deposited successfully.");
            checkBalance();
        } else {
            System.out.println("Amount must be greater than zero.");
        }
    }

    private void showTransactionHistory() {
        List<Transaction> transactions = account.getTransactions();

        System.out.println("\n====== TRANSACTION HISTORY ======");

        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void showAccountDetails() {
        System.out.println("\n====== ACCOUNT DETAILS ======");
        System.out.println("Account Holder: "
                + account.getAccountHolder());
        System.out.println("Account Number: "
                + account.getAccountNumber());
        checkBalance();
    }

    private int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private double readAmount(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }
}
