import java.util.Scanner;
public class CarArray{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Car[] carArray= {

        new Car("Audi", "Q7", 2020, 100000, false),
        new Car("Audi", "Etron", 2021, 120000, false),
        new Car("BMW", "X5", 2019, 95000, true),
        new Car("BMW", "X6", 2021, 120000, true)

        };
        System.out.println("Car Management System");
        System.out.println("1. Display all cars");
        System.out.println("2. Find the most expensive car");
        System.out.println("3. Calculate average price");
        System.out.println("4. Check if a car is leased");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                for (Car car : carArray) {
                    car.displayDetails();
                }
                break;
            case 2:
                Car.findMostExpensiveCar(carArray);
                break;
            case 3:
                Car.averagePrice(carArray);
                break;
            case 4:
                Car.isLeased(carArray);
                break;
            case 5:
                System.out.println("Exiting program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }
}
class Car {
    private String make;
    private String model;
    private int year;
    private int price;
    private boolean isLeased;

    public Car(String make, String model, int year, int price, boolean isLeased) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isLeased = false;
    }

    public String make() {
        return make;
    }

    public String model() {
        return model;
    }

    public int year() {
        return year;
    }

    public double price() {
        return price;
    }

    public boolean isLeased() {
        return isLeased;
    }

    public void setLease(Boolean newLease){
        isLeased = newLease;
    }

    public void displayDetails() {
        System.out.println("Make: " + make + " Model: " + model + " Year: " + year + " Price: " + price);
        if (isLeased) {
            System.out.println("leased");
        } else {
            System.out.println("not leased");
        }

    }

    public double getPrice() {
        return price;
    }

    public static void findMostExpensiveCar(Car[] cars) {
        Car mostExpensive = cars[0];
        for (Car car : cars) {
            if (car.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = car;
            }
        }
        System.out.println("The most expensive car is " + mostExpensive.model);
    }

    public static void averagePrice(Car[] cars) {
        double sum = 0;
        int count = 0;
        for (Car car : cars) {
            sum += car.getPrice();
            count++;
        }
        System.out.println("Average price:" + sum / count);
    }

    public static void isLeased(Car[] cars) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which car to lease. Enter the model");

        String entered = scanner.nextLine();
        for (int i = 0; i < cars.length; i++) {
            if (entered.equalsIgnoreCase(cars[i].model())) {
                cars[i].isLeased = true;
            }
        }
    }
}
