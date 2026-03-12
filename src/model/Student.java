package model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;

    public Student(int id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Student ID: " + getId() +
                "\nName: " + getName() +
                "\nEmail: " + getEmail() +
                "\nPhone Number: " + getPhoneNumber();
    }
}