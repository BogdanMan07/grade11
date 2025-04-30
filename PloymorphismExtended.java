public class PolymorphismExtended{
    public static void main(String[] args){


        Vehicle[] vehicles = {
            new Car("Audi", 2020, "Etron"),
            new Motorcycle("Harley-Davidson", 2022, "Quattro"),
            new Car("Pagani", 2018, "Zonda"),
        };

        for(Vehicle v: vehicles){
            v.displayDetails();
            v.startEngine();
        }

    }
}
class Vehicle{
    String brand;
    int year;
    String model;

    public Vehicle(String brand, int year, String model){
        this.brand = brand;
        this.year = year;
        this.model = model;
    }
    public void displayDetails() {
        System.out.println("Brand: " + brand + ", Year: " + year+ ", Model: " + model);
    }

    public void startEngine() {
        System.out.println("Starting the engine");
    }
}

class Car extends Vehicle{
    public Car(String brand, int year, String model){
        super(brand, year, model);
    }

    public void displayDetails(){
        System.out.println("Brand: " + brand + ", Year: " + year + ", Model: " + model);
    }

    public void startEngine() {
        System.out.println("Roaarrrrrrrrrrrrrrrr");
    }
}

class Motorcycle extends Vehicle{
    public Motorcycle(String brand, int year, String model){
        super(brand, year, model);
    }
    public void displayDetails(){
        System.out.println("Brand: " + brand + ", Year: " + year + ", Model: " + model);

    }
    public void startEngine() {
        System.out.println("Vrummmmmmmmmmmmmmmmmmmmm");
    }
}
