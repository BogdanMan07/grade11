import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        int number = 5;
        Scanner reader = new Scanner(System.in);
        System.out.println("Guess a number between (1-10):");
        int num1 = reader.nextInt();
        int attempt = 3;

        if (attempt <= 3) {
            if (num1 == 5) {
                System.out.println("You guessed the number.");
            } else if (num1 > 5) {
                System.out.println("Your number is bigger.");
                attempt--;
            } else {
                System.out.println("Your number is smaller. ");
                attempt--;
            }
        }
        if (attempt <= 3) {
            num1 = reader.nextInt();
            if (num1 == 5) {
                System.out.println("You guessed the number.");
            } else if (num1 >= 5) {
                System.out.println("Your number is bigger.");
                attempt--;
            } else {
                System.out.println("Your number is smaller. ");
                attempt--;
            }
        }

        if (attempt <= 3) {
            num1 = reader.nextInt();
            if (num1 == 5) {
                System.out.println("You guessed the number.");
            } else if (num1 >= 5) {
                System.out.println("Your number is bigger.");
                attempt--;
            } else {
                System.out.println("Your number is smaller. ");
                attempt--;
            }
        }
    }
}
