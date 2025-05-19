import java.io.*;

public class ObjectSerialization {
    public static void main(String[] args) {
        Employee empl1 = new Employee(1213, "Mimi", 20);

        empl1.writeToFile("records.txt");
        empl1.readFromFile("records.txt");
    }
}

class Employee implements Serializable{
    private int employeeID;
    private String name;
    private int age;

    public Employee(int employeeID, String name, int age){
        this.employeeID = employeeID;
        this.name=name;
        this.age=age;
    }

    public void writeToFile(String path){
        try(ObjectOutputStream print = new ObjectOutputStream(new FileOutputStream(path))){
            print.writeObject(this);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(String path){
        try(ObjectInputStream read = new ObjectInputStream(new FileInputStream(path))){
            try{
                while(true){
                    Employee empl1 = (Employee) read.readObject();
                    System.out.println("id: " + empl1.employeeID + "name: " + empl1.name + " age: " + empl1.age);
                }
            }catch(EOFException e){};
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
