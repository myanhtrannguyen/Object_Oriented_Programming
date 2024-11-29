import java.util.Date;

public class Transaction{
    private Date date;
    private String type;
    private double amount;
    private double BalanceAfterTransaction;

    public Transaction(String type, double amount, double BalanceAfterTransaction) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.BalanceAfterTransaction = BalanceAfterTransaction;
    }

    public Date getDate() {

        return date;
    }

    public String getType() {

        return type;
    }

    public double getAmount() {

        return amount;
    }

    public double getBalanceAfterTransaction() {

        return BalanceAfterTransaction;
    }
}{
}
