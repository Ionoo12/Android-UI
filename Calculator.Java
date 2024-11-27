import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private String operator;
    private double operand1, operand2;
    private boolean isOperatorClicked;

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background color change
        getContentPane().setBackground(new Color(28, 28, 28)); // Darker background color

        // Declarative: Create a display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBackground(new Color(40, 40, 40)); // Slightly lighter dark background for display
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create and style the display text field
        display = new JTextField();
        display.setFont(new Font("Roboto", Font.PLAIN, 28)); // Use Roboto font
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(new Color(50, 50, 50)); // Dark gray background for display
        display.setForeground(Color.WHITE); // White text
        display.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        displayPanel.add(display, BorderLayout.CENTER);

        // Add display panel to the frame
        add(displayPanel, BorderLayout.NORTH);

        // Declarative: Create a button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(40, 40, 40)); // Same color for button panel
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Define button labels
        String[] buttonTexts = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+",
        };

        // Declaratively add buttons and listeners
        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setFont(new Font("Roboto", Font.BOLD, 20)); // Roboto font for buttons
            button.setFocusPainted(false);

            // Button color changes
            if (text.matches("\\d")) { // Number buttons
                button.setBackground(new Color(60, 60, 60)); // Dark gray for numbers
                button.setForeground(Color.WHITE);
            } else if ("C".equals(text)) { // Clear button
                button.setBackground(new Color(211, 47, 47)); // Red for 'C'
                button.setForeground(Color.WHITE);
            } else if ("=".equals(text)) { // Equals button
                button.setBackground(new Color(41, 121, 255)); // Blue for '='
                button.setForeground(Color.WHITE);
            } else { // Operator buttons
                button.setBackground(new Color(249, 168, 37)); // Yellow-orange for operators
                button.setForeground(Color.BLACK);
            }

            button.addActionListener(this); // Attach event listeners
            buttonPanel.add(button);
        }

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle button clicks programmatically
        if (command.matches("\\d")) { // Numbers
            if (isOperatorClicked) {
                display.setText(command);
                isOperatorClicked = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if ("C".equals(command)) { // Clear
            display.setText("");
            operator = null;
            operand1 = operand2 = 0;
        } else if ("=".equals(command)) { // Equals
            if (operator != null) {
                operand2 = Double.parseDouble(display.getText());
                double result = calculate(operand1, operand2, operator);
                display.setText(String.valueOf(result));
                operator = null;
            }
        } else { // Operators (+, -, *, /)
            operator = command;
            operand1 = Double.parseDouble(display.getText());
            isOperatorClicked = true;
        }
    }

    private double calculate(double op1, double op2, String operator) {
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op2 != 0 ? op1 / op2 : 0; // Handle divide by zero
            default -> 0;
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private String operator;
    private double operand1, operand2;
    private boolean isOperatorClicked;

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background color change
        getContentPane().setBackground(new Color(28, 28, 28)); // Darker background color

        // Declarative: Create a display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBackground(new Color(40, 40, 40)); // Slightly lighter dark background for display
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create and style the display text field
        display = new JTextField();
        display.setFont(new Font("Roboto", Font.PLAIN, 28)); // Use Roboto font
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(new Color(50, 50, 50)); // Dark gray background for display
        display.setForeground(Color.WHITE); // White text
        display.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        displayPanel.add(display, BorderLayout.CENTER);

        // Add display panel to the frame
        add(displayPanel, BorderLayout.NORTH);

        // Declarative: Create a button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(40, 40, 40)); // Same color for button panel
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Define button labels
        String[] buttonTexts = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+",
        };

        // Declaratively add buttons and listeners
        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setFont(new Font("Roboto", Font.BOLD, 20)); // Roboto font for buttons
            button.setFocusPainted(false);

            // Button color changes
            if (text.matches("\\d")) { // Number buttons
                button.setBackground(new Color(60, 60, 60)); // Dark gray for numbers
                button.setForeground(Color.WHITE);
            } else if ("C".equals(text)) { // Clear button
                button.setBackground(new Color(211, 47, 47)); // Red for 'C'
                button.setForeground(Color.WHITE);
            } else if ("=".equals(text)) { // Equals button
                button.setBackground(new Color(41, 121, 255)); // Blue for '='
                button.setForeground(Color.WHITE);
            } else { // Operator buttons
                button.setBackground(new Color(249, 168, 37)); // Yellow-orange for operators
                button.setForeground(Color.BLACK);
            }

            button.addActionListener(this); // Attach event listeners
            buttonPanel.add(button);
        }

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle button clicks programmatically
        if (command.matches("\\d")) { // Numbers
            if (isOperatorClicked) {
                display.setText(command);
                isOperatorClicked = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if ("C".equals(command)) { // Clear
            display.setText("");
            operator = null;
            operand1 = operand2 = 0;
        } else if ("=".equals(command)) { // Equals
            if (operator != null) {
                operand2 = Double.parseDouble(display.getText());
                double result = calculate(operand1, operand2, operator);
                display.setText(String.valueOf(result));
                operator = null;
            }
        } else { // Operators (+, -, *, /)
            operator = command;
            operand1 = Double.parseDouble(display.getText());
            isOperatorClicked = true;
        }
    }

    private double calculate(double op1, double op2, String operator) {
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op2 != 0 ? op1 / op2 : 0; // Handle divide by zero
            default -> 0;
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private String operator;
    private double operand1, operand2;
    private boolean isOperatorClicked;

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background color change
        getContentPane().setBackground(new Color(28, 28, 28)); // Darker background color

        // Declarative: Create a display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBackground(new Color(40, 40, 40)); // Slightly lighter dark background for display
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create and style the display text field
        display = new JTextField();
        display.setFont(new Font("Roboto", Font.PLAIN, 28)); // Use Roboto font
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(new Color(50, 50, 50)); // Dark gray background for display
        display.setForeground(Color.WHITE); // White text
        display.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        displayPanel.add(display, BorderLayout.CENTER);

        // Add display panel to the frame
        add(displayPanel, BorderLayout.NORTH);

        // Declarative: Create a button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(40, 40, 40)); // Same color for button panel
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Define button labels
        String[] buttonTexts = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+",
        };

        // Declaratively add buttons and listeners
        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setFont(new Font("Roboto", Font.BOLD, 20)); // Roboto font for buttons
            button.setFocusPainted(false);

            // Button color changes
            if (text.matches("\\d")) { // Number buttons
                button.setBackground(new Color(60, 60, 60)); // Dark gray for numbers
                button.setForeground(Color.WHITE);
            } else if ("C".equals(text)) { // Clear button
                button.setBackground(new Color(211, 47, 47)); // Red for 'C'
                button.setForeground(Color.WHITE);
            } else if ("=".equals(text)) { // Equals button
                button.setBackground(new Color(41, 121, 255)); // Blue for '='
                button.setForeground(Color.WHITE);
            } else { // Operator buttons
                button.setBackground(new Color(249, 168, 37)); // Yellow-orange for operators
                button.setForeground(Color.BLACK);
            }

            button.addActionListener(this); // Attach event listeners
            buttonPanel.add(button);
        }

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle button clicks programmatically
        if (command.matches("\\d")) { // Numbers
            if (isOperatorClicked) {
                display.setText(command);
                isOperatorClicked = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if ("C".equals(command)) { // Clear
            display.setText("");
            operator = null;
            operand1 = operand2 = 0;
        } else if ("=".equals(command)) { // Equals
            if (operator != null) {
                operand2 = Double.parseDouble(display.getText());
                double result = calculate(operand1, operand2, operator);
                display.setText(String.valueOf(result));
                operator = null;
            }
        } else { // Operators (+, -, *, /)
            operator = command;
            operand1 = Double.parseDouble(display.getText());
            isOperatorClicked = true;
        }
    }

    private double calculate(double op1, double op2, String operator) {
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op2 != 0 ? op1 / op2 : 0; // Handle divide by zero
            default -> 0;
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private String operator;
    private double operand1, operand2;
    private boolean isOperatorClicked;

    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background color change
        getContentPane().setBackground(new Color(28, 28, 28)); // Darker background color

        // Declarative: Create a display panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBackground(new Color(40, 40, 40)); // Slightly lighter dark background for display
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create and style the display text field
        display = new JTextField();
        display.setFont(new Font("Roboto", Font.PLAIN, 28)); // Use Roboto font
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(new Color(50, 50, 50)); // Dark gray background for display
        display.setForeground(Color.WHITE); // White text
        display.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        displayPanel.add(display, BorderLayout.CENTER);

        // Add display panel to the frame
        add(displayPanel, BorderLayout.NORTH);

        // Declarative: Create a button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(40, 40, 40)); // Same color for button panel
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Define button labels
        String[] buttonTexts = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+",
        };

        // Declaratively add buttons and listeners
        for (String text : buttonTexts) {
            JButton button = new JButton(text);
            button.setFont(new Font("Roboto", Font.BOLD, 20)); // Roboto font for buttons
            button.setFocusPainted(false);

            // Button color changes
            if (text.matches("\\d")) { // Number buttons
                button.setBackground(new Color(60, 60, 60)); // Dark gray for numbers
                button.setForeground(Color.WHITE);
            } else if ("C".equals(text)) { // Clear button
                button.setBackground(new Color(211, 47, 47)); // Red for 'C'
                button.setForeground(Color.WHITE);
            } else if ("=".equals(text)) { // Equals button
                button.setBackground(new Color(41, 121, 255)); // Blue for '='
                button.setForeground(Color.WHITE);
            } else { // Operator buttons
                button.setBackground(new Color(249, 168, 37)); // Yellow-orange for operators
                button.setForeground(Color.BLACK);
            }

            button.addActionListener(this); // Attach event listeners
            buttonPanel.add(button);
        }

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Handle button clicks programmatically
        if (command.matches("\\d")) { // Numbers
            if (isOperatorClicked) {
                display.setText(command);
                isOperatorClicked = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if ("C".equals(command)) { // Clear
            display.setText("");
            operator = null;
            operand1 = operand2 = 0;
        } else if ("=".equals(command)) { // Equals
            if (operator != null) {
                operand2 = Double.parseDouble(display.getText());
                double result = calculate(operand1, operand2, operator);
                display.setText(String.valueOf(result));
                operator = null;
            }
        } else { // Operators (+, -, *, /)
            operator = command;
            operand1 = Double.parseDouble(display.getText());
            isOperatorClicked = true;
        }
    }

    private double calculate(double op1, double op2, String operator) {
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op2 != 0 ? op1 / op2 : 0; // Handle divide by zero
            default -> 0;
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
