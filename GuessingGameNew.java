import java.util.Scanner; //Import Scanner
import java.util.Random;
public class GuessingGameNew {
    public static void main(String[] args) {
        Random rand = new Random(); //Create a random object
        Scanner reader = new Scanner(System.in);
        int randomNumber = 0;
        randomNumber = rand.nextInt(100) + 1; //Generate a random number
        System.out.println(randomNumber);




        System.out.println("----------------------------");
        System.out.println("Welcome to Guessing Game Updated");
        System.out.println("----------------------------");
        System.out.println("Let's play a game! I am going to think of a number between 1 and 100 and you have to guess it...");
        System.out.println("----------------------------");
        System.out.println("I am ready! Let's play!");
        System.out.println("----------------------------");
        System.out.println("Note! If you want to quit the game type \"quit\"");
        System.out.println("----------------------------");
        System.out.print("Your guess is: ");
        int attempts= 0; //Number of attempts
        boolean guess = false;


        while(!guess){
            attempts++;


            if (reader.hasNextInt()) {
                int userInput = reader.nextInt();
                if (userInput > randomNumber) {
                    System.out.println("Your number is bigger! ");
                } else if (userInput < randomNumber) {
                    System.out.println("Your number is smaller! ");
                } else if (userInput == randomNumber) {
                    System.out.println("Congratulations you guessed the number in " + attempts + " attempts!");
                } else {
                    String invalidInput = reader.next(); // Consume the invalid input
                    System.out.println("Error: '" + invalidInput + "' is not a valid number.");
                    guess = true; // End loop
                }
            }
            else {
                String InvalidInput = reader.next(); //Deal with Invalid Input
                if(InvalidInput.equals("quit")) { // Quit option
                    System.out.println("Goodbye!");
                    guess = true;
                } else {
                    System.out.println("Error: '" + InvalidInput + "' is not a valid number.");
                }
            }
        }
        reader.close();// close scanner 
    }
}

