package MyJava.Concepts;
class AccountException extends Exception {
    public AccountException(Throwable ex) {
        super(ex);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }

    public InsufficientBalanceException() {
        super("Insufficient funds in your account.");
    }

}

class Account {
    private float balance;

    public Account(float initialDeposit) {
        balance = initialDeposit;
    }

    public void withdraw(float value) throws AccountException {
        if (value > balance)
            throw new AccountException(new InsufficientBalanceException());
    }
}

public class ChainingException {
    public static void main(String[] args) {
        var account = new Account(10);
        try {
            account.withdraw(15);
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println(cause.getMessage());
        }
    }
}
