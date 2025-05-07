import java.io.*;
import java.util.Scanner;

public class GroceryListToFile {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter the name of the file: ");
        String fileName = reader.nextLine();
        String message = " ";

        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("Enter grocery items one by one (type 'done' to finish):");

            while (true) {
                String item = reader.nextLine();
                if (item.equalsIgnoreCase("done")) {
                    break;
                }
                message+= item + "\n";
            }

            System.out.println("Shopping list saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        reader.close();
    }
}
