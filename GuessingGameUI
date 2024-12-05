import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGameUI {
    public static void main(String[] args) {
        Random guess = new Random();
        int unknown = guess.nextInt(100) + 1;
        int[] attempts = {0};

        // Frame
        JFrame frame = new JFrame("Guessing Game");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(7, 1));

        // Panels
        JPanel welcome = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Welcome to the Guessing Game. Let's play!");
        welcome.add(label);

        JPanel play = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("I'm thinking of a number between 1 and 100. Can you guess it?");
        play.add(label1);

        JPanel note = new JPanel(new FlowLayout());
        JLabel label2 = new JLabel("Note: If you want to quit, click \"Quit\".");
        note.add(label2);

        JPanel output = new JPanel(new FlowLayout());
        JLabel result = new JLabel("");
        output.add(result);

        JTextField input = new JTextField(8);

        // Buttons
        JPanel buttons = new JPanel(new FlowLayout());
        JButton enter = new JButton("Enter");
        JButton quit = new JButton("Quit");

        buttonStyle(enter);
        buttonStyle(quit);

        buttons.add(enter);
        buttons.add(quit);

        // Add to frame
        frame.add(welcome);
        frame.add(play);
        frame.add(note);
        frame.add(input);
        frame.add(output);
        frame.add(buttons);

        frame.setVisible(true);

        // Enter button
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int userInput = Integer.parseInt(input.getText());
                    if (userInput < 1 || userInput > 100) {
                        result.setText("Please enter a number between 1 and 100.");
                        return;
                    }

                    attempts[0]++; // Increment attempt counter
                    if (userInput > unknown) {
                        result.setText("Your number is higher!");
                    } else if (userInput < unknown) {
                        result.setText("Your number is lower!");
                    } else {
                        result.setText("Congratulations! The number is: " + unknown + " Your numbe of attempts is: " + attempts[0]);
                    }
                } catch (NumberFormatException a) {
                    result.setText("Not valid number!.");
                }
            }
        });

        // Quit button
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 45));
        button.setForeground(Color.BLUE);
    }
}
