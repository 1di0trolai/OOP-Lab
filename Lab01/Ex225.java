package Lab01;

import javax.swing.JOptionPane;

public class Ex225 {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, 
            "Please input the first number: ", "Input the first number",
            JOptionPane.INFORMATION_MESSAGE);
        
        strNum2 = JOptionPane.showInputDialog(null, 
            "Please input the second number: ", "Input the second number",
            JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        
        double sum = num1 + num2;
        double dif = num1 - num2;
        double pro = num1 * num2;
        double quo = (num2 != 0) ? num1 / num2 : 0;

        String strNotification = "Sum: " + sum + "\n"
                               + "Difference: " + dif + "\n"
                               + "Product: " + pro +"\n"
                               + "Quotient: " + (num2 != 0 ? quo : "Cannot divide by 0");
                               
        JOptionPane.showMessageDialog(null, strNotification,
            "Result", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}
