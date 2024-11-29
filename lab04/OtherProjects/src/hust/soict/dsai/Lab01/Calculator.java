import javax.swing.JOptionPane;
public class Calculator{
public static void main (String[] args){
    String strNum1, strNum2;

    strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
    strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);

    double Num1 = Double.parseDouble(strNum1);
    double Num2 = Double.parseDouble(strNum2);

    double sum = Num1 + Num2;
    double difference = Num1 - Num2;
    double product = Num1 * Num2;

    JOptionPane.showMessageDialog(null, "" + sum,"Show the sum", JOptionPane.INFORMATION_MESSAGE);

    JOptionPane.showMessageDialog(null, "" + difference, "Show the difference: ", JOptionPane.INFORMATION_MESSAGE);

    JOptionPane.showMessageDialog(null, "" + product, "Show the product: ", JOptionPane.INFORMATION_MESSAGE);

    if (Num2 != 0){
        double quotient = Num1 / Num2;
        JOptionPane.showMessageDialog(null, "" + quotient, "Show the quotient: ", JOptionPane.INFORMATION_MESSAGE);
    } else{
        JOptionPane.showMessageDialog(null, "Math Error", "Show the quotient: ", JOptionPane.INFORMATION_MESSAGE);
    }
    System.exit(0);
}
}