package codeReview7;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseOperations {

    private static final String username = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/cr7_ekinci";

    private PreparedStatement preparedStatement;
    private Connection connection;


    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public ArrayList <Student> getAllStudents() throws SQLException {
        establishConnection();
        ArrayList <Student> students = new ArrayList <>();
        String selectCommand = "select * from students;";
        preparedStatement = connection.prepareStatement(selectCommand);
        ResultSet resultset = preparedStatement.executeQuery();
        while (resultset.next()) {
            String name = resultset.getString("student_name");
            String surname = resultset.getString("student_surname");
            String email = resultset.getString("student_email");
            Student student = new Student(name, surname, email);
            students.add(student);
        }
        closeConnection();
        return students;
    }

    public ArrayList <Teacher> getAllTeachers() throws SQLException {
        establishConnection();
        ArrayList <Teacher> teachers = new ArrayList <>();
        String selectCommand = "select * from teachers;";
        preparedStatement = connection.prepareStatement(selectCommand);
        ResultSet resultset = preparedStatement.executeQuery();
        while (resultset.next()) {
            String name = resultset.getString("teacher_name");
            String surname = resultset.getString("teacher_surname");
            String email = resultset.getString("teacher_email");
            Teacher teacher = new Teacher(name, surname, email);
            teachers.add(teacher);
        }
        closeConnection();
        return teachers;
    }

    public ArrayList <Course> getAllCourses() throws SQLException {
        establishConnection();
        ArrayList <Course> courses = new ArrayList <>();
        String selectCommand = "select * from classes;";
        preparedStatement = connection.prepareStatement(selectCommand);
        ResultSet resultset = preparedStatement.executeQuery();
        while (resultset.next()) {
            String name = resultset.getString("class_name");
            Course course = new Course(name);
            courses.add(course);
        }
        closeConnection();
        return courses;
    }


    public ArrayList <Course> getAllCoursesForTeacherById(int id) throws SQLException {

        establishConnection();
        ArrayList <Course> courses = new ArrayList <>();
        String selectCommand = "select class_name from classes, teacher_class where" +
                " classes.class_id = teacher_class.fk_class_id and teacher_class.fk_teacher_id = " + id;
        preparedStatement = connection.prepareStatement(selectCommand);
        ResultSet resultset = preparedStatement.executeQuery();
        while (resultset.next()) {
            String name = resultset.getString("class_name");
            Course course = new Course(name);
            courses.add(course);
        }
        closeConnection();
        return courses;
    }
}