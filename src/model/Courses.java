package model;

public class Courses {
    private int id;
    private String title;
    private String teacher;

    public Courses(int id,String title, String teacher){
        this.id = id;
        this.title = title;
        this.teacher = teacher;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "Courses ID: " + getId() +
                "\nTitle: " + getTitle() +
                "\nTeacher: " +getTeacher();
    }
}
