package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        // Create just one student
//        Student student1 = new Student();
//        student1.enroll();
//        student1.payTuition();
//        System.out.println(student1.toString());

        // Ask how many new users we want to add
        System.out.print("Enter number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        // Array of students
        Student[] student  = new Student[size];

        // Create a number of new students
        for(int n=0; n<size; n++){
            student[n] = new Student();
            student[n].enroll();
            student[n].payTuition();
            System.out.println(student[n].toString());
        }
    }



}
