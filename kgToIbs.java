import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class kgToIbs{

    public static void main(String[] args) {
        // Initialize MaximumCalculations object with a limit of 3 calculations
        MaximumCalculations maxCalc = new MaximumCalculations(3);

        // Create the main frame
        JFrame frame = new JFrame("Unit Converter");
        frame.setSize(1000, 800);
        frame.setLayout(new BorderLayout(2, 1));

        // Create a text area for displaying output messages
        JPanel text = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 10);
        textArea.setFont(new Font("Arial", Font.PLAIN, 30));
        textArea.setForeground(Color.GREEN); // Default text color
        textArea.setEditable(false); // Disable editing
        text.add(textArea);

        // Create an input panel with a labeled text field for weight input
        JPanel textPanel = new JPanel();
        JTextField textFieldUnits = new JTextField("", 15);
        textPanel.add(createLabeledPanel("Weight units:", textFieldUnits));

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        JButton kgToPoundsButton = new JButton("Convert kilograms to pounds");
        JButton poundsToKgButton = new JButton("Convert pounds to kilograms");

        buttonStyle(kgToPoundsButton);
        buttonStyle(poundsToKgButton);

        // Add buttons to the panel
        buttonPanel.add(kgToPoundsButton);
        buttonPanel.add(poundsToKgButton);

        // Add all components to the frame
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(text, BorderLayout.SOUTH);

        frame.setVisible(true);

        // ActionListener for converting kilograms to pounds
        kgToPoundsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double units = Double.parseDouble(textFieldUnits.getText());

                // Validation for negative and large values
                if (units < 0) {
                    textArea.setForeground(Color.RED);
                    textArea.setText("Negative weight doesn't exist! Please enter a positive value!");
                    return;
                }
                if (units > 999) {
                    textArea.setForeground(Color.RED);
                    textArea.setText("Weight is too high! Try again!");
                    return;
                }

                maxCalc.convertKgToPounds(new Units(units), textArea);
            }
        });

        // ActionListener for converting pounds to kilograms
        poundsToKgButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double units = Double.parseDouble(textFieldUnits.getText());

                // Validation for negative and large values
                if (units < 0) {
                    textArea.setForeground(Color.RED);
                    textArea.setText("Negative weight doesn't exist! Please enter a positive value!");
                    return;
                }
                if (units > 2202) {
                    textArea.setForeground(Color.RED);
                    textArea.setText("Weight is too high! Try again!");
                    return;
                }

                maxCalc.convertPoundsToKg(new Units(units), textArea);
            }
        });
    }

    // Method to style buttons
    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.WHITE); // Text color
        button.setBackground(Color.BLUE); // Background color
        button.setFocusPainted(false);
    }

    // Method to create a panel with a label and text field
    public static JPanel createLabeledPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(label);
        panel.add(textField);
        return panel;
    }
}

// Class to represent a weight unit
class Units {
    double units;
    //constructor
    public Units(double units) {
        this.units = units;
    }
    //getter method
    public double getUnits() {
        return units;
    }
}

// Class to follow conversion logic and track maximum allowed calculations
class MaximumCalculations {
    private ArrayList<Units> unitConversions; // List to store conversions
    private int space; // Maximum allowed calculations
    private double coefficient = 0.45359237; // Conversion coefficient (pounds to kilograms)
    //constructor
    public MaximumCalculations(int space) {
        this.space = space;
        this.unitConversions = new ArrayList<>();
    }

    // Method to convert kilograms to pounds
    void convertKgToPounds(Units units, JTextArea textArea) {
        if (unitConversions.size() < space) {
            unitConversions.add(units);
            double result = Math.round(units.getUnits() / coefficient * 1000.0) / 1000.0;
            textArea.setText(units.getUnits() + " kilograms converted to pounds is " + result + " pounds.");
        } else {
            textArea.setText("You have reached your maximum number of free calculations!");
        }
    }

    // Method to convert pounds to kilograms
    void convertPoundsToKg(Units units, JTextArea textArea) {
        if (unitConversions.size() < space) {
            unitConversions.add(units);
            double result = Math.round(units.getUnits() * coefficient * 1000.0) / 1000.0;
            textArea.setText(units.getUnits() + " pounds converted to kilograms is " + result + " kilograms.");
        } else {
            textArea.setText("You have reached your maximum number of free calculations!");
        }
    }
}
