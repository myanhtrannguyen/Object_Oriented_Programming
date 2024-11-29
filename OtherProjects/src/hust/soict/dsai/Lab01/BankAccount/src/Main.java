//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Please Enter Account Holder Name: ");
        double initialBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Initial Balance: "));

        BankAccount account = new BankAccount(name, initialBalance);

        while (true) {
            String[] options = {
                    "Deposit",
                    "Withdraw",
                    "Check Current Balance",
                    "Apply Monthly Interest",
                    "View Transactions Log",
                    "Exit"
            };

            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Please choose an operation: ",
                    "Bank Account Management",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    double depositAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Amount to Deposit: "));
                    account.deposit(depositAmount);
                    break;

                case 1:
                    double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Amount to Withdraw: "));
                    account.withdrawals(withdrawAmount);
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, String.format("Your Current Balance is: %.2f", account.getBalance()));
                    break;

                case 3:
                    account.PrintTransactionsLog();
                    break;

                case 4:
                    account.MonthlyInterest();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Thank you for choosing us!");
                    System.exit(0);

                default:
                    break;
            }
        }
    }
}