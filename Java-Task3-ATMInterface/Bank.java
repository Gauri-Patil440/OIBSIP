

public class Bank {
    private Account account;

    public Bank() {
        // Demo account for this ATM project.
        account = new Account("1001001", "Gauri Patil",
                              "1234", 10000.00);
    }

    public Account authenticate(String enteredPin) {
        if (account.verifyPin(enteredPin)) {
            return account;
        }

        return null;
    }
}
