import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class kgToIbs {

    public static void main(String[] args) {
        MaximumCalculations maxCalc = new MaximumCalculations(3);

        JFrame frame = new JFrame("Unit Converter");
        frame.setSize(1000, 800);

        frame.setLayout(new BorderLayout(2, 1));

        JPanel text = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 10);
        textArea.setFont(new Font("Arial", Font.PLAIN, 30));
        textArea.setForeground(Color.GREEN);
        textArea.setEditable(false);
        text.add(textArea);

        JPanel textPanel = new JPanel();
        JTextField textFieldUnits = new JTextField("", 15);
        textPanel.add(createLabeledPanel("Weight units:", textFieldUnits));

        JPanel buttonPanel = new JPanel();
        JButton kgToPoundsButton = new JButton("Convert kilograms to pounds");
        JButton poundsToKgButton = new JButton("Convert pounds to kilograms");

        buttonStyle(kgToPoundsButton);
        buttonStyle(poundsToKgButton);

        buttonPanel.add(kgToPoundsButton);
        buttonPanel.add(poundsToKgButton);

        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(text, BorderLayout.SOUTH);

        frame.setVisible(true);

        kgToPoundsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double units = Double.parseDouble(textFieldUnits.getText());

                if (units < 0) {
                    textArea.setForeground(Color.RED);
                    textArea.setText("Negative weight doesn't exist! Please enter a positive value!");
                    return;
                }
                if (units>999) {
                    textArea.setForeground(Color.RED);
                    textArea.setText("Weight is too high! Try again!");
                    return;
                }

                maxCalc.convertKgToPounds(new Units(units), textArea);
            }
        });

        poundsToKgButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double units = Double.parseDouble(textFieldUnits.getText());

                if (units < 0) {
                    textArea.setForeground(Color.RED);
                    textArea.setText("Negative weight doesn't exist! Please enter a positive value!");
                    return;
                }
                if (units>2202) {
                    textArea.setForeground(Color.RED);
                    textArea.setText("Weight is too high! Try again!");
                    return;
                }

                maxCalc.convertPoundsToKg(new Units(units), textArea);
            }


        });
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setFocusPainted(false);
    }

    public static JPanel createLabeledPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(label);
        panel.add(textField);
        return panel;
    }
}

class Units {
    double units;

    public Units(double units) {
        this.units = units;
    }

    public double getUnits() {
        return units;
    }
}

class MaximumCalculations {
    private ArrayList<Units> unitConversions;
    private int space;
    private double coefficient = 0.45359237;

    public MaximumCalculations(int space) {
        this.space = space;
        this.unitConversions = new ArrayList<>();
    }

    void convertKgToPounds(Units units, JTextArea textArea) {
        if (unitConversions.size() < space) {
            unitConversions.add(units);
            double result = Math.round(units.getUnits() / coefficient * 1000.0) / 1000.0;
            textArea.setText(units.getUnits() + " kilograms converted to pounds is " + result + " pounds.");
        } else {
            textArea.setText("You have reached your maximum number of free calculations!");
        }
    }

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
