import java.util.Scanner;
public class OnlineBookstore {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] titles = {"Harry Potter", "Absolvo Te", "Beartown", "Timeshelter"};
        double[] price = {20.0, 22.5, 18.50, 25.50};
        int[] quantity = {10, 15, 18, 25};
        int[] code = {1, 2, 3, 4};

        System.out.println("Menu:");
        System.out.println("1. Display Items");
        System.out.println("2. Search for a Book");
        System.out.println("3. Purchase a Book");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = reader.nextInt();
        reader.nextLine();

        switch (choice) {
            case 1:
                displayItems(titles, price, quantity);
                break;
            case 2:
                searchBook(titles, price, quantity);
                break;
            case 3:
                searchAndPurchase(titles, price, quantity, code);
                break;
            case 4:
                System.out.println("Thank you for using the bookstore system!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        reader.close();
    }

    public static void displayItems(String[] titles, double[] price, int[] quantity) {
        for (int i = 0; i < titles.length; i++) {
            System.out.println("Name: " + titles[i] +"Code:"+ (i+1) + " Price: " + price[i] + " lv." + " Quantity: " + quantity[i]);
        }
    }

    public static void searchBook(String[] titles, double[] price, int[] quantity) {
        boolean found = false;
        System.out.println("Search for a book:");
        Scanner reader = new Scanner(System.in);
        String search = reader.nextLine();
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equalsIgnoreCase(search)) {
                System.out.println( (i+1) + ". " + titles[i] + " Price: " + price[i] + " Quantity: " + quantity[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No book found.");
        }
    }

    public static void searchAndPurchase(String[] titles, double[] price, int[] quantity, int[] code) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the code of the book you want to purchase: ");
        int pick = reader.nextInt();
        reader.nextLine();

        for (int i = 0; i < titles.length; i++) {
            if (code[i] == pick) {
                if (quantity[i] == 0) {
                    System.out.println("Sorry, " + titles[i] + " is out of stock.");
                    return;
                }

                System.out.println("You have selected " + titles[i]);
                System.out.println("Price: " + price[i] + " lv.");
                System.out.print("Enter your balance: ");
                double balance = reader.nextDouble();
                reader.nextLine();

                double newbalance = balance - price[i];
                System.out.println("Payment was accepted! " +price[i]+ "lv. were withdrawn from your card.");
                    quantity[i]--;
                    System.out.println("You just bought " + titles[i] + ". Thank you!");
            }
        }
    }
}
