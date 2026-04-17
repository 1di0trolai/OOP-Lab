package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;

public class Ex226 {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog(
                "Choose: \n1. Linear equation\n2. Linear system\n3. Quadratic equation");

        switch (choice) {
            case "1":
                solveLinear();
                break;
            case "2":
                solveSystem();
                break;
            case "3":
                solveQuadratic();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice!");
        }
    }

    // Linear equation
    static void solveLinear() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b: "));

        if (a == 0) {
            if (b == 0)
                JOptionPane.showMessageDialog(null, "Infinite solutions");
            else
                JOptionPane.showMessageDialog(null, "No solution");
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "x = " + x);
        }
    }

    // Linear system
    static void solveSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11: "));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12: "));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1: "));

        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21: "));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22: "));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2: "));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0)
                JOptionPane.showMessageDialog(null, "Infinite solutions");
            else
                JOptionPane.showMessageDialog(null, "No solution");
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "x1 = " + x1 + " and x2 = " + x2);
        }
    }

    // Quadratic equation
    static void solveQuadratic() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c: "));

        double delta = b * b - 4 * a * c;

        if (a == 0) {
            solveLinear();
        } else {
            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "No solution");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Double root x = " + x);
            } else {
                double x1 = (-b - Math.sqrt(delta)) / (2 * a);
                double x2 = (-b + Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + " and x2 = " + x2);
            }
        }
    }
}
