package budget;

public class Balance {
    private static double balance = 0;

    public static void addIncome(double income) {
        balance += income;
    }

    public static void removeBalance(double b) {
        balance -= b;
        if (balance < 0) {
            balance = 0;
        }
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double balance) {
        Balance.balance = balance;
    }
}
