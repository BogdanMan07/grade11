import java.util.Scanner;
public class ArrayVending {
    public static void main(String[] args) {
       Scanner reader= new Scanner(System.in);
       String[] names= {"1.Bake Rolls","2.Oreo","3.Soleti","4.Nestea"};
       double[] price= {2.0,2.5,0.6,1.7};
       int[] quantity= {1,2,3,4};
       int[] code= {1,2,3,4};

       displayItems(names, price, quantity);
       SelectAndPurchase(names, price, quantity, code);
       displayItems(names, price, quantity);



    }
    public static void displayItems(String[] names, double[] price, int[] quantity){
        for(int i=0; i<names.length; i++) {
            System.out.println("Name: " + names[i] + " Price: " + price[i] + " Quantity: " + quantity[i]);
        }
    }

    public static void SelectAndPurchase(String[] names, double[] price, int[] quantity, int[]code){
        Scanner reader= new Scanner(System.in);
        System.out.println("Please enter the code of the product: ");
        int choice= reader.nextInt();
        for(int i=0; i<names.length; i++) {
            if(code[i]==choice) {
                System.out.println("You have purchased " + names[i] );
                System.out.println("You need to insert: " + price[i]);
                double insert= reader.nextDouble();
                if(insert<price[i]) {
                    double add=price[i]-insert;
                    System.out.println("You need to insert:" + add);
                }
                else if(insert>price[i]){
                    double change= insert-price[i];
                    System.out.printf("Your change is: %.2f", change);
                }
                else{
                    System.out.println("Please take your: " + names[i]);
                    quantity[i]=quantity[i]-1;
                }
            }
        }


    }

}
