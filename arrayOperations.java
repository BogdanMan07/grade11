import java.util.Scanner;
public class arrayOperations {
    public static void main(String[] args) {
        String[] students = {"Nikoleta", "Vasil", "Martin", "Svetoslav", "Irina", "Aleksandar"};
        int[] grades = {99, 49, 89, 45, 35, 78};
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("The average of the students is: "+ calculateAverage(grades));
                break;
            case 2:
                System.out.println(findHighestGradeStudent(students, grades));
                break;
            case 3:
                System.out.println(findLowestGradeStudent(students, grades));
                break;
            case 4:
                System.out.println("The number of failed students is: " + countFailedStudents(grades));
                break;
            case 5:
                System.out.println("Name of the student:");
                String studentToLookUp = scanner.nextLine();
                System.out.println(lookupStudentGrade(students, grades, studentToLookUp));
                break;
            case 6:
                break;
        }

    }


    private static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }

    private static String findHighestGradeStudent(String[] studentNames, int[] grades) {
        int maxIndex = 0;
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > grades[maxIndex]) {
                maxIndex = i;
            }
        }
        return studentNames[maxIndex] + " with grade " + grades[maxIndex];
    }

    private static String findLowestGradeStudent(String[] studentNames, int[] grades) {
        int minIndex = 0;
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < grades[minIndex]) {
                minIndex = i;
            }
        }
        return studentNames[minIndex] + " with grade " + grades[minIndex];
    }

    private static int countFailedStudents(int[] grades) {
        int count = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 50) {
                count++;
            }
        }
        return count;
    }

    private static int lookupStudentGrade(String[] studentNames, int[] grades, String studentToLookup) {
        int index = 0;
        for (int i = 0; i < grades.length; i++) {
            if (studentNames[i].equals(studentToLookup)) {
                index = i;
            }
        }
        return grades[index];
    }
}
