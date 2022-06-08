package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private String studentID;
    private int costOfCourse =600;
    private int tuitionBalance=0;
    private String courses="";
    private static int id = 1000;

    //Constructor:  prompt user to enter name and year
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student firstname: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student lastname: ");
        this.lastName = in.nextLine();

        System.out.println("1-Freshmen\n2-Sophmore\n3-Junior\n4-Senior");
        System.out.print("Enter your grade year: ");
        this.year = in.nextInt();

        setStudentID();
        System.out.println("Enrolled in: "+ courses);

//        System.out.println(firstName + lastName + year+studentID);
    }

    //Generate Id
    private void setStudentID(){
        // Grade level + id
        id++;
        this.studentID = year+""+id;
    }

    //Enrol in courses
    public void enroll(){
        boolean con = true;
        do{
            System.out.print("Enter course to enroll or Q to quit: ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")){
                courses = courses + "\n"+course;
                tuitionBalance=tuitionBalance+costOfCourse;
            }
            else{con=false;}
        }while(con);
    }

    //View balance
    public void viewBalance(){
        System.out.println("Balance "+tuitionBalance);
    }

    //Pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance =  tuitionBalance - payment;
        System.out.println("Thanks for your payments of $"+payment);
        viewBalance();

    }

//    public void payTuition(int payment){
//        tuitionBalance =  tuitionBalance - payment;
//        System.out.println("Thanks for your payments of $"+payment);
//        viewBalance();
//    }

    //Show status
    public String toString(){
        return "Name: " + firstName + " " + lastName +
                "\nGrade level: " + year +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nAccount balance: " + tuitionBalance;
    }
}
