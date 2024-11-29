import javax.swing.*;

public class SystemOfEquations {
public static void main(String[] args) {
    // Giải phương trình bậc nhất dạng ax + b = 0
    String inputA = JOptionPane.showInputDialog(null, "Please input a: ", "Input a", JOptionPane.INFORMATION_MESSAGE);
    String inputB = JOptionPane.showInputDialog(null, "Please input b: ", "Input b", JOptionPane.INFORMATION_MESSAGE);

    double a = Double.parseDouble(inputA);
    double b = Double.parseDouble(inputB);

    if (a == 0) {
        JOptionPane.showMessageDialog(null, "Math Error", "Show result", JOptionPane.INFORMATION_MESSAGE);
    } else {
        double x = -b / a;
        JOptionPane.showMessageDialog(null, "x: " + x, "Show result", JOptionPane.INFORMATION_MESSAGE);
    }

    // Giải hệ phương trình bậc nhất hai ẩn
    String inputA1 = JOptionPane.showInputDialog(null, "Please input a1: ", "Input a1", JOptionPane.INFORMATION_MESSAGE);
    String inputB1 = JOptionPane.showInputDialog(null, "Please input b1: ", "Input b1", JOptionPane.INFORMATION_MESSAGE);
    String inputC1 = JOptionPane.showInputDialog(null, "Please input c1: ", "Input c1", JOptionPane.INFORMATION_MESSAGE);
    String inputA2 = JOptionPane.showInputDialog(null, "Please input a2: ", "Input a2", JOptionPane.INFORMATION_MESSAGE);
    String inputB2 = JOptionPane.showInputDialog(null, "Please input b2: ", "Input b2", JOptionPane.INFORMATION_MESSAGE);
    String inputC2 = JOptionPane.showInputDialog(null, "Please input c2: ", "Input c2", JOptionPane.INFORMATION_MESSAGE);

    double a1 = Double.parseDouble(inputA1);
    double b1 = Double.parseDouble(inputB1);
    double c1 = Double.parseDouble(inputC1);
    double a2 = Double.parseDouble(inputA2);
    double b2 = Double.parseDouble(inputB2);
    double c2 = Double.parseDouble(inputC2);

    double delta = a1 * b2 - a2 * b1;
    if (delta == 0) {
        if (b1 * c2 - b2 * c1 != 0) {
            JOptionPane.showMessageDialog(null, "The system has no solution", "Show result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The system has infinitely many solutions", "Show result", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        double x1 = (c1 * b2 - c2 * b1) / delta;
        double x2 = (a1 * c2 - a2 * c1) / delta;
        JOptionPane.showMessageDialog(null, "x1: " + x1 + " and x2: " + x2, "Show result", JOptionPane.INFORMATION_MESSAGE);
    }

    // Giải phương trình bậc hai dạng ax^2 + bx + c = 0
    String inputA0 = JOptionPane.showInputDialog(null, "Please input a: ", "Input a", JOptionPane.INFORMATION_MESSAGE);
    String inputB0 = JOptionPane.showInputDialog(null, "Please input b: ", "Input b", JOptionPane.INFORMATION_MESSAGE);
    String inputC0 = JOptionPane.showInputDialog(null, "Please input c: ", "Input c", JOptionPane.INFORMATION_MESSAGE);

    double a0 = Double.parseDouble(inputA0);
    double b0 = Double.parseDouble(inputB0);
    double c0 = Double.parseDouble(inputC0);

    double delta0 = b0 * b0 - 4 * a0 * c0;
    if (a0 == 0) {
        JOptionPane.showMessageDialog(null, "Result: " + (-c0 / b0), "Show result", JOptionPane.INFORMATION_MESSAGE);
    } else {
        if (delta0 < 0) {
            JOptionPane.showMessageDialog(null, "The function has no solution", "Show result", JOptionPane.INFORMATION_MESSAGE);
        } else if (delta0 == 0) {
            JOptionPane.showMessageDialog(null, "Result: " + (-b0 / (2 * a0)), "Show result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            double deltaRoot = Math.sqrt(delta0);
            double x1 = (-b0 + deltaRoot) / (2 * a0);
            double x2 = (-b0 - deltaRoot) / (2 * a0);
            JOptionPane.showMessageDialog(null, "Result: x1 = " + x1 + ", x2: " + x2, "Show result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
}