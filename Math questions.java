import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class MathQuestions {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the math quiz! Please enter your name:");
        String studentName = reader.nextLine().trim().toLowerCase();
        String outputFileName = studentName + "-answers.txt";

        try {
            PrintWriter fileWriter = new PrintWriter(new FileWriter(outputFileName));

            for (int i = 1; i <= 5; i++) {
                int firstNumber = random.nextInt(100) + 1;
                int secondNumber = random.nextInt(100) + 1;
                char operator;
                int correctAnswer = 0;

                int operationType = random.nextInt(3);
                if (operationType == 0) {
                    operator = '+';
                    correctAnswer = firstNumber + secondNumber;
                } else if (operationType == 1) {
                    operator = '-';
                    correctAnswer = firstNumber - secondNumber;
                } else {
                    operator = '*';
                    correctAnswer = firstNumber * secondNumber;
                }

                System.out.println("Question " + i + ": " + firstNumber + " " + operator + " " + secondNumber + " = ?");
                int studentAnswer = reader.nextInt();

                boolean isCorrect = studentAnswer == correctAnswer;

                fileWriter.println("Question " + i + ": " + firstNumber + " " + operator + " " + secondNumber +
                        " = " + studentAnswer + " | Correct Answer: " + correctAnswer + " | " +
                        (isCorrect ? "Correct" : "Incorrect"));
            }

            fileWriter.close();
            System.out.println("Your answers have been saved in: " + outputFileName);

        } catch (IOException e) {
            System.out.println("There was a problem writing to the file.");
            e.printStackTrace();
        }

        reader.close();
    }
}
