import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

class BankAccount {
    private String AccountHolderName;
    private double Balance;
    private double MonthlyInterestRate;
    private List<Transaction> Transactions;
    private int WithdrawalsThisMonth;
    private static final int MAX_WITHDRAWALS = 3;

    public BankAccount (String AccountHolderName, double InitialBalance) {
        if (AccountHolderName.equals("") || AccountHolderName == null || AccountHolderName.equals(" ") || AccountHolderName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Account Holder Name or Account Holder Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid Account Holder Name.");
        }

        if(InitialBalance < 0) {
            JOptionPane.showMessageDialog(null, "Initial Balance cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid Initial Balance.");
        }

        this.AccountHolderName = AccountHolderName;
        this.Balance = InitialBalance;
        this.MonthlyInterestRate = 0.0;
        this.Transactions = new ArrayList<>();
        this.WithdrawalsThisMonth = 0;

        if(InitialBalance > 0) {
            Transactions.add(new Transaction("Initial Deposit", InitialBalance, InitialBalance));
        }

        String message = String.format("Account created successfully!\n\n" + "Account Holder: %s\n" + "Initial Balance: %.2f VND\n" + "Monthly Interest Rate: %.1f%%", AccountHolderName, InitialBalance, MonthlyInterestRate * 100);
        JOptionPane.showMessageDialog(null, message, "Account Created!", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public double getBalance() {
        return Balance;
    }

    public double getMonthlyInterestRate() {
        return MonthlyInterestRate;
    }

    public int getWithdrawalsThisMonth() {
        return WithdrawalsThisMonth;
    }

    public void resetMonthlyWithdrawals() {
        WithdrawalsThisMonth = 0;
        JOptionPane.showMessageDialog(null, "Monthly withdrawal limit has been reset.", "Withdrawal Limit Reset", JOptionPane.INFORMATION_MESSAGE);
    }

    public void SetMonthlyInterestRate(double rate) {
        if (rate < 0) {
            JOptionPane.showMessageDialog(null, "Interest rate cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.MonthlyInterestRate = rate;
        JOptionPane.showMessageDialog(null, String.format("Interest rate updated to %.1f%%", rate * 100), "Interest Rate Updated", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deposit (double amount) {
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid Deposit Amount. Please enter a valid deposit amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Balance = Balance + amount;
        Transactions.add(new Transaction("Deposit", amount, Balance));

        JOptionPane.showMessageDialog(null, String.format("Successfully deposited %.2f VND\nNew balance: %.2f VND", amount, Balance));
    }

    public void withdrawals (double amount) {
        if (WithdrawalsThisMonth >= MAX_WITHDRAWALS) {
            JOptionPane.showMessageDialog(null, "You have reached the limit withdrawals this month!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (amount <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid Withdraw Amount. Please enter a valid withdraw amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (amount > Balance) {
            JOptionPane.showMessageDialog(null, "Exceed current balance!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Balance = Balance - amount;
        WithdrawalsThisMonth += 1;
        Transactions.add(new Transaction("Withdraw", amount, Balance));

        JOptionPane.showMessageDialog(null, String.format("Successfully withdrawn %.2f VND\nNew balance: %.2f VND", amount, Balance));
    }

    public void MonthlyInterest() {
        double MonthlyInterestRate = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter the desired Interest Rate: "));
        double InterestAmount = Balance * MonthlyInterestRate;
        Balance = Balance + InterestAmount;

        Transactions.add(new Transaction("Interest", InterestAmount, Balance));

        String message = String.format("Monthly Interest Applied:\n" + "Interest Rate: %.1f%%\n" + "Interest Amount: %.2f VND\n" + "New Balance: %.2f VND", MonthlyInterestRate * 100, InterestAmount, Balance);
        JOptionPane.showMessageDialog(null, message, "Interest Calculation", JOptionPane.INFORMATION_MESSAGE);

    }

    public void PrintTransactionsLog() {
        if (Transactions.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No transactions found!");
            return;
        }

        StringBuilder log = new StringBuilder();
        log.append("Transaction Log:\n\n");

        for (Transaction t : Transactions) {
            log.append(String.format("%s: %.2f VND\t", t.getType(), t.getAmount()));
            log.append(String.format("Date: %s\t", t.getDate()));
            log.append(String.format("Balance After Transaction: %.2f VND\n\n", t.getBalanceAfterTransaction()));
        }

        JOptionPane.showMessageDialog(null, log.toString(), "Transaction Log", JOptionPane.INFORMATION_MESSAGE);
    }
}
