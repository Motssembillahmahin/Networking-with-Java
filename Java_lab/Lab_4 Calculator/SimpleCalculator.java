package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalButton, clearButton;
    private double firstNumber, secondNumber, result;
    private String operator;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            final int num = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + num);
                }
            });
        }

        addButton = createOperatorButton("+");
        subtractButton = createOperatorButton("-");
        multiplyButton = createOperatorButton("*");
        divideButton = createOperatorButton("/");

        equalButton = new JButton("=");
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondNumber = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }
                textField.setText(String.valueOf(result));
                operator = null;
            }
        });

        clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                firstNumber = 0;
                secondNumber = 0;
                operator = null;
            }
        });

        panel.add(textField);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divideButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(multiplyButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subtractButton);
        panel.add(numberButtons[0]);
        panel.add(clearButton);
        panel.add(equalButton);
        panel.add(addButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton createOperatorButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operator == null) {
                    firstNumber = Double.parseDouble(textField.getText());
                    operator = text;
                    textField.setText("");
                }
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}
