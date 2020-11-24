package ru.geekbrains.javacore.lesson08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyWindow extends JFrame {
    private String expression = "0";
    private String numberText = "0";
    private char operator = '\0';

    private float expressionValue = 0f;

    JTextPane expressionText = new JTextPane();
    JTextField numberTextField = new JTextField();

    MyWindow() {
        String[] calcSymbols = {"7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "+/-","0",".","+", "="
        };

        setLocation(100,100);
        setSize(500,500);
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        add(mainPanel);


        expressionText.setEditable(false);


        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 20;
        constraints.weightx = 0.0;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(expressionText, constraints);



        constraints.ipady = 15;
        constraints.weightx = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(numberTextField, constraints);


        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processButton(((JButton)e.getSource()).getText());

            }
        };

        JPanel buttonsPanel = new JPanel(new GridLayout(5,4));
        for (int i = 0; i < calcSymbols.length; i++) {
            JButton button = new JButton(calcSymbols[i]);
            buttonsPanel.add(button);
            button.addActionListener(buttonListener);
        }


        constraints.ipady = 0;
        constraints.weighty = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(buttonsPanel, constraints);
        pack();
        setResizable(false);
        setVisible(true);


    }

    void processButton(String text) {
        if (text.equals("+/-")) {
            if (numberText.charAt(0) == '-') {
                setNumberText(numberText.substring(1));
            }
            else {
                setNumberText("-" + numberText);
            }
        }
        else if (text.equals("/")||text.equals("*")||text.equals("-")||text.equals("+")) {
            setOperator(text.charAt(0));
        }
        else if (text.equals("=")) {
            calcExpression();
        }
        else if (numberText.equals("0")) {
            setNumberText(text);
        }
        else {
            setNumberText(numberText + text);
        }
    }


    void setNumberText(String numberText) {
        this.numberText = numberText;
        numberTextField.setText(numberText);
    }

    void setOperator(char c) {
        if (expression.isEmpty()) {
            setExpression(numberText);
            setNumberText("0");
        }
        else {
            calcExpression();
        }

        operator = c;
    }
    void calcExpression() {
        float value = Float.parseFloat(numberText);
        if (operator == '\0') {
            expressionValue = value;
        }
        else if ((operator == '/' || operator == '*')&&(value == 0f)) {
            expressionValue = 0f;
        }
        else if (operator == '/') {
            expressionValue /= value;
        }
        else if (operator == '*') {
            expressionValue *= value;
        }
        else if (operator == '-') {
            expressionValue -= value;
        }
        else if (operator == '+') {
            expressionValue += value;
        }

        setExpression(Float.toString(expressionValue));
        setNumberText("0");
        operator = '\0';

    }

    void setExpression(String text) {
        expression = text;
        expressionText.setText(text);
    }

}


