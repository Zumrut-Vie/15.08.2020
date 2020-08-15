package codeReview7;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private String name;
    private String surname;
    private String email;
    private List <Course> courses;

    public Teacher(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.courses = new ArrayList <>();
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public List <Course> getCourses() {
        return courses;
    }
    public void setCourses(List <Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "First name: " + name + ", surname: " + surname + ", Email: " + this.email;
    }
}
