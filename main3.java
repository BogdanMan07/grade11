import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please choose a product:");
        System.out.println("Code A1: Product Soda - Price: $1.50");
        System.out.println("Code B2: Product Chips - Price: $1.25");
        System.out.println("Code C3: Product Candy - Price: $0.75");
        System.out.println("Code D4: Product Water - Price: $1.00");
        System.out.println("Enter code:");
        String code = reader.next();

        switch (code) {
            case "A1":
                System.out.println("Product Soda - Price: $1.50");
                break;
            case "B2":
                System.out.println("Product Chips - Price: $1.25");
                break;
            case "C3":
                System.out.println("Product Candy - Price: $0.75");
                break;
            case "D4":
                System.out.println("Product Water - Price: $1.00");
                break;

            default:
                System.out.println("Invalid code");
                break;
        }
    }
}
