package codeReview7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationDriver {

    DatabaseOperations databaseOperations = new DatabaseOperations();
    Scanner input = new Scanner(System.in);

    public void printMenu() {
        System.out.println("Press 1 to display all students");
        System.out.println("Press 2 to display all teachers");
        System.out.println("Press 3 to display all classes");
        System.out.println("Press 4 to display all classes for teacher");
        System.out.println("Press 5 to create a report in a text format");
        System.out.println("Press 6 to quit");
    }

    public void run() throws SQLException, IOException {
        int userChoice = 0;
        while (userChoice != 6) {
            printMenu();
            userChoice = input.nextInt();
            if (userChoice == 1) {
                printMessage("ALL STUDENTS ARE: ", getStudentInfo(databaseOperations.getAllStudents()));
            }
            if (userChoice == 2) {
                printMessage("ALL TEACHERS ARE: ", getTeacherInfo(databaseOperations.getAllTeachers()));
            }
            if (userChoice == 3) {
                printMessage("ALL CLASSES ARE: ", getCourseInfo(databaseOperations.getAllCourses()));
            }
            if (userChoice == 4) {
                System.out.println("Please input the teacher ID below: ");
                int id = input.nextInt();
                printMessage("ALL COURSES FOR TEACHER WITH ID '" + id + "' ARE: ",
                        getCourseInfo(databaseOperations.getAllCoursesForTeacherById(id)));
            }
            if (userChoice == 5) {
                System.out.println("Please input the file name: ");
                String fileName = input.nextLine();
                fileName = input.nextLine();
                createReport(fileName);
            }
            if (userChoice == 6) {
                printMessage("BYE!", "END OF THE PROGRAM");
            }
        }
    }

    private String getStudentInfo(ArrayList <Student> objectArrayList) {
        String result = "";
        for (Student object : objectArrayList) {
            result += object.toString() + "\n";
        }
        return result;
    }

    private String getTeacherInfo(ArrayList <Teacher> objectArrayList) {
        String result = "";
        for (Teacher object : objectArrayList) {
            result += object.toString() + "\n";
        }
        return result;
    }

    private String getCourseInfo(ArrayList <Course> objectArrayList) {
        String result = "";
        for (Course object : objectArrayList) {
            result += object.toString() + "\n";
        }
        return result;
    }

    public void printMessage(String header, String message) {
        System.out.println("------------------------ " + header + "------------------------");
        System.out.println(message);
        System.out.println("------------------------------------------------------------");
    }

    private void writeToFile(String fileName, String text) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(text);
        fileWriter.close();
    }

    public void createReport(String fileName) throws IOException, SQLException {

        String studentInfo = getStudentInfo(databaseOperations.getAllStudents());
        String teacherInfo = getTeacherInfo(databaseOperations.getAllTeachers());
        String allCourseInfo = getCourseInfo(databaseOperations.getAllCourses());

        String lineOne = "\n------------------------ DATABASE REPORT ------------------------\n";

        String lineTwo = "\n------------------------ ALL STUDENTS ARE :  ------------------------\n";
        lineTwo += "\n" + studentInfo + "\n";

        String lineThree = "\n------------------------ ALL TEACHERS ARE :  ------------------------\n";
        lineThree += "\n" + teacherInfo + "\n";

        String lineFour = "\n------------------------ ALL CLASSES ARE :  ------------------------\n";
        lineFour += "\n" + allCourseInfo + "\n";

        writeToFile(fileName, lineOne + lineTwo + lineThree + lineFour);
    }


    public static void main(String[] args) {
        ApplicationDriver driver = new ApplicationDriver();
        try {
            driver.run();
        } catch (Exception exc) {
            System.out.println("ERROR: " + exc.getMessage());
        }
    }
}