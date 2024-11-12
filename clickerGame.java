import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clickerGame {

    public static void main(String[] args) {

       JFrame frame = new JFrame("clicker game");
       JLabel showCLicks = new JLabel("0");
       JButton clickButton = new JButton("click me");
       JButton dontclickButton = new JButton(" don't click me");
       JButton resetButton = new JButton("reset");


       frame.setLayout(new GridLayout(4,1));
       frame.setSize(300,300);
       frame.add(showCLicks);
       frame.add(clickButton);
       frame.add(dontclickButton);
       frame.add(resetButton);

       frame.setVisible(true);

       clickButton.addActionListener(new ActionListener(){

           public void actionPerformed(ActionEvent e){
               int counter = Integer.parseInt(showCLicks.getText());
               counter++;
               showCLicks.setText(String.valueOf(counter));
           }
       });
       dontclickButton.addActionListener(new ActionListener() {

           public void actionPerformed(ActionEvent e) {
               int counter1 = Integer.parseInt(showCLicks.getText());
                 if(counter1 != 0){
                       counter1--;
                       }
               showCLicks.setText(String.valueOf(counter1));
           }
       });
       resetButton.addActionListener(new ActionListener() {

           public void actionPerformed(ActionEvent e) {
               int reset = Integer.parseInt(showCLicks.getText());
                     showCLicks.setText("0");

           }
       });

    }
}
