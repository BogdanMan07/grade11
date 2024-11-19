public class addressbookTask1 {
    public static void main(String[] args) {
        // Task 6: Create more objects and test the methods
        Person p1 = new Person("Eda", "eda@gmail.com", "123-456-7890", 18);
        p1.print();
        Person p2 = new Person("Hannah", "hannah@gmail.com", "404-899-9955", 24);
        p2.print();

        p1.updateEmail("edayavuz@gmail.com");
        System.out.println("Updated email: "+ p1.getEmail());

    }
}


class Person {
    private String name;
    private String email;
    private String phoneNumber;
    private int age;


    public Person(String initName, String initEmail, String initPhone, int age) { 
        name = initName;
        email = initEmail;
        phoneNumber = initPhone;
        this.age= age;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Age: " + age);
    }

    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getAge() {
        return age;
    }

    public void updateEmail(String newEmail) {
        email= newEmail;
}
}
