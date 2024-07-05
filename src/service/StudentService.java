package service;

import model.Student;

import java.util.Scanner;

public class StudentService {

    public Student create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter surname: ");
        String surname = scanner.next();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter mark: ");
        double mark = scanner.nextDouble();
        System.out.print("Enter gender: ");
        char gender = scanner.next().charAt(0);
        System.out.print("Enter isPHD: ");
        boolean isPHD = scanner.next().equals("yes");

        return new Student(name, surname, year, mark, gender, isPHD);
    }

    public Student oldestStudent(Student s1, Student s2) {
        return s1.getYear() < s2.getYear() ? s1 : s2;
    }

    public Student youngestStudent(Student[] students) {
        Student youngest = students[0];
        if (youngest == null) {
            return null;
        }
        for (int i = 1; i < students.length; i++) {
            if (students[i] != null && students[i].getYear() > youngest.getYear()) {
                youngest = students[i];
            }
        }
        return youngest;
    }

    public void printGirls(Student[] students) {
        for (Student student : students) {
            if (student.getGender() == 'f' || student.getGender() == 'F') {
                student.printInfo();
                System.out.println("******************************");
            }
        }
    }

    public void printYoungestGirlInfo(Student[] students) {
        Student youngestGirl = null;

        for (int i = 0; i < students.length; i++) {

            if (students[i].getGender() == 'f' || students[i].getGender() == 'F') {

                if (youngestGirl == null) {
                    youngestGirl = students[i];
                } else {

                    if (students[i].getYear() > youngestGirl.getYear()) {
                        youngestGirl = students[i];
                    }

                }

            }
        }

        if(youngestGirl == null) {
            System.out.println("There are no girl students.");
        }
        else {
            youngestGirl.printInfo();
        }

    }

}
