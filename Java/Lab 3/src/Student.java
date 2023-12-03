import java.util.ArrayList;

public class Student {
    //Assigned variables to be used
    private String name;
    private String department;
    private int age;
    private String userName;
    private int studentNumber;
    private boolean fullTime;
    //Private Arraylist for grades
    private ArrayList<Grade> grades = new ArrayList<>();
    //Constructor to set intial values of the variables
    public Student(String name, String department, int age, int studentNumber, boolean fullTime) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.studentNumber = studentNumber;
        this.fullTime = fullTime;
        this.userName = name.charAt(0) + name.substring(name.indexOf(" ") + 1, name.indexOf(" ") + 5) + ("" + studentNumber).substring(0, 3);
    }
    //Getters and Setters for the variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }
    //Adds subject and grade to grades arraylist
    public void addGrade(String subject, int score) {
        grades.add(new Grade(subject, score));
    }
    //Get the grade list from the arraylist
    public ArrayList<Grade> getGradeList() {
        return grades;
    }
}
