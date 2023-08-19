package lab;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
public class RestaurantBillGenerator {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JButton button;
    public static void main(String[] args) {
        new RestaurantBillGenerator();
    }
    public RestaurantBillGenerator() {
        frame = new JFrame("Restaurant Bill Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        label = new JLabel("Enter your order:");
        textField = new JTextField();
        button = new JButton("Generate Bill");
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String order = textField.getText();
                double totalCost = 0;
                for (String item : order.split(",")) {
                    if (item.equals("Pizza")) {
                        totalCost += 100;
                    } else if (item.equals("Burger")) {
                        totalCost += 30;
                    } else if (item.equals("Tea")) {
                        totalCost += 10;
                    } else {
                        System.out.println("Invalid item.");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Your bill is $" + totalCost);
            }
        });
    }
}

