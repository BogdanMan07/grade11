import java.io.*;
import java.util.Random;

public class BinaryFiles {
    public static void main(String[] args) {
        readEmp("sample.txt");
        writeEmp("sample.txt");
    }

    public static void readEmp(String path) {
        Random rand = new Random();

        try (DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path))) {
            for (int i = 0; i < 5; i++) {
                int studentId = 1000 + i;
                String name = "Name" + i;
                int gradeLevel = 9 + rand.nextInt(4);
                double gpa = 2.5 + (rand.nextDouble() * 1.8);

                outStream.writeInt(studentId);
                outStream.writeUTF(name);
                outStream.writeInt(gradeLevel);
                outStream.writeDouble(gpa);
            }
        } catch (EOFException e) {
        } catch (IOException e) {
            System.out.println("There was a mistake: " + e.getMessage());
        }
    }

    public static void writeEmp(String path) {
        try (DataInputStream inStream = new DataInputStream(new FileInputStream(path))) {
            while (true) {
                int studentId = inStream.readInt();
                String name = inStream.readUTF();
                int gradeLevel = inStream.readInt();
                double gpa = inStream.readDouble();

                System.out.println("ID: " + studentId);
                System.out.println("Name: " + name);
                System.out.println("Grade Level: " + gradeLevel);
                System.out.println("GPA:"+ gpa);

            }
        } catch (IOException e) {
            System.out.println("there was a mistake: " + e.getMessage());
        }
    }
}
