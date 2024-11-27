public class HonorStudent{
   public static void main(String[] args){
       Students s1 = new Students ("Kamen", "Nikolov", 11, 2, "ACS");
       Students s2= new Students ("Bogdan", "Nakov", 11, 4, "ACS");


       s1.HonorStudentEmail();
       s2.HonorStudentEmail();
   }
}


class Students {


   private String name;
   private String lastName;
   private int gradeLevel;
   private double gpa;
   private String schoolName;


   public Students(String name, String lastName, int gradeLevel, double gpa, String schoolName) {
       this.name = name;
       this.lastName = lastName;
       this.gradeLevel = gradeLevel;
       this.gpa = gpa;
       this.schoolName = schoolName;
   }


   boolean isHonorStudent() {
       return gpa >= 3.8;
   }
   void HonorStudentEmail() {
       if(isHonorStudent()){
       System.out.println( "Dear " + name + ", you are selected as one of the honor students of " +schoolName+ " in class 2023 with the GPA of " +gpa+ ". Congratulations and we look forward to celebrating your achievement in the graduation ceremony. ");
   }
   }
}
