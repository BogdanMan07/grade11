import java.util.Scanner;
public class Main {
   public static void main(String[] args) {
       Scanner reader= new Scanner(System.in);
       System.out.println("Please choose a category.");
       System.out.println("1.Science");
       System.out.println("2.History");
       System.out.println("3.Sports");
       System.out.println("Category:");
       byte choice = reader.nextByte();
      
       switch (choice) {
           case 1:
               System.out.println("How do  you call a motion in two-dimensions?");
               String ans1= reader.next();
               if (ans1.equals("projectile")) {
                   System.out.println("Correct! You earned 1 point.");
               } else{
                   System.out.println("Incorrect. The correct answer is projectile.");
               }
               break;
           case 2:
               System.out.println("When was Bulgaria founded?");
               int ans2= reader.nextInt();
               if (ans2==681) {
                   System.out.println("Correct! You earned 1 point.");
               } else{
                   System.out.println("Incorrect. The correct answer is 681.");
               }
               break;
           case 3:
               System.out.println("Which team won the EuroLeague in 2024?");
               String ans3= reader.next();
               if (ans3.equals("Panathinaikos")) {
                   System.out.println("Correct! You earned 1 point.");
               } else{
                   System.out.println("Incorrect. The correct answer is Panathinaikos.");
               }
               break;


           default:
               System.out.println("Invalid input");
       }
   }
}
