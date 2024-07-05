import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Lesson {
    public static void main(String[] args) {

        boolean isActive = true;
        Student[] students = new Student[10];
        int index = 0;
        StudentService service = new StudentService();

        while(isActive) {
            System.out.println("1: Enter a new student");
            System.out.println("2: Older student between first two students");
            System.out.println("3: Youngest student in the array");
            System.out.println("4: Print all girl Students");
            System.out.println("5: Print youngest girl info");
            System.out.println("6: Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if(index < students.length - 1) {
                        Student newStudent = service.create();
                        students[index] = newStudent;
                        index++;
                    }
                    break;
                case 2:
                    if(index > 1) {
                        Student oldestStudent = service.oldestStudent(students[0], students[1]);
                        oldestStudent.printInfo();
                    } else {
                        System.out.println("There should be at least 2 students");
                    }
                    break;
                case 3:
                    Student[] array3  = new Student[index];
                    for(int i = 0; i < array3.length; i++) {
                        array3[i] = students[i];
                    }
                    Student youngestStudent = service.youngestStudent(array3);
                    youngestStudent.printInfo();
                    break;
                case 4:
                    Student[] array4  = new Student[index];
                    for(int i = 0; i < array4.length; i++) {
                        array4[i] = students[i];
                    }
                    service.printGirls(array4);
                    break;
                case 5:
                    Student[] array5  = new Student[index];
                    for(int i = 0; i < array5.length; i++) {
                        array5[i] = students[i];
                    }
                    service.printYoungestGirlInfo(array5);
                    break;
                case 6:
                    isActive = false;
            }
        }


    }
}