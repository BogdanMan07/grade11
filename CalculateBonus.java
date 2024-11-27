public class CalculateBonus{
    public static void main(String[] args){
        Employee empl1 = new Employee ("Kamen", "Nikolov", "1232", 5000.0, 4.5);
        Employee empl2 = new Employee ("Bogdan", "Nakov", "1324", 30000.0, 8.9);


        empl1.sendPerformanceEmail();
        empl2.sendPerformanceEmail();
    }
}


class Employee {


    private String firstName;
    private String lastName;
    private String employeeID;
    private double salary;
    private double performanceRating;


    public Employee(String firstName, String lastName, String employeeID, double salary, double performanceRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }


    boolean isHigherPerformer() {
        return performanceRating >= 4.5;

    }
    int calculateBonus(){
        if (isHigherPerformer()) {
            return (int)(salary= 0.2*salary);
        }
        else{
            return (int)(salary= 0.05*salary);
        }
    }

    void sendPerformanceEmail() {
        if(isHigherPerformer()){
            System.out.println("Dear " + firstName + " " + lastName+ ", \n "  +
                    "Based on your performance rating of " + performanceRating+ " you are a valued member of our team.\n" +
                    "Your bonus for this period is " + calculateBonus()+ ". Keep up the great work!");
        }
    }
}
