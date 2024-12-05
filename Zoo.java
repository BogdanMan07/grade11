public class Zoo {


    public static void main(String[] args) {
        Habitat savannah = new Habitat("Savannah", 4000, 32 );
        Habitat rainforest= new Habitat( "Rainforest", 5000, 26);
        Habitat desert= new Habitat ("Desert", 3000,40);
        Habitat forest= new Habitat("Forst", 1000, 20);
        Zoo zoo= new Zoo();
        Staff zooCEO= new Staff("Bogdan","CEO of the zoo");
        Staff zookeeper= new Staff("Dichev", "zookeeper");
        Staff zoocleaner= new Staff("Vasko", "zoocleaner");
        zoo.addAnimal1("Kamen", "bear", 34,forest);
        zoo.addAnimal2("Maria", "tiger",2,savannah);
        zoo.addAnimal3("Ivaylo", "camel", 15, desert);
        zoo.addAnimal4("Ani-Mimi", "pelican", 21, rainforest);

        zookeeper.assignStaff(desert);
        zoocleaner.assignStaff(rainforest);


    }
}


class Animal {
    private String name;
    private String species;
    private int age;
    Habitat habitat;


    public Animal(String name, String species, int age, Habitat habitat) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.habitat = habitat;
    }
}


class Habitat {
    private String type;
    private double size;
    private int temperature;


    public Habitat(String type, double size, int temperature) {
        this.type = type;
        this.size = size;
        this.temperature = temperature;

    }
    String getType(){
        return type;
    }
}
class Zoo {
    private Animal a1;
    private Animal a2;
    private Animal a3;
    private Animal a4;


    void addAnimal1(String name, String species, int age, Habitat habitat){
        a1= new Animal(name, species, age, habitat);
    }


    void addAnimal2(String name, String species, int age, Habitat habitat){
        a2= new Animal(name, species, age, habitat);
    }


    void addAnimal3(String name, String species, int age, Habitat habitat) {
        a3 = new Animal(name, species, age, habitat);
    }


    void addAnimal4(String name, String species, int age, Habitat habitat){
        a4= new Animal(name, species, age, habitat);
    }

}


class Staff{
    private String name;
    private String role;
    private Habitat assignedHabitat;


    public Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void assignStaff(Habitat habitat){
        assignedHabitat = habitat;
        System.out.println("Staff named " + name + " is assigned to habitat named " + habitat.getType());
    }
}
