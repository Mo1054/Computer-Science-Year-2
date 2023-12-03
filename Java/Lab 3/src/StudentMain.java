///Import libaries
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    //Create new array list
    private static final ArrayList<Student> students = new ArrayList<Student>();
    //user New Scanner
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ///Add the students and their Grades for courses
        students.add(new Student("Bert Smith", "computing", 21, 12345, true));
        students.add(new Student("Olivia Green", "computing", 19, 23464, true));
        students.add(new Student("Eloise Jones", "computing", 18, 34744, true));
        students.add(new Student("Ben Bird", "computing", 42, 34834, false));
        students.add(new Student("Karen Brown", "computing", 25, 45632, false));
        students.get(0).addGrade("programming", 52);
        students.get(0).addGrade("web dev", 63);
        students.get(0).addGrade("maths", 76);
        students.get(0).addGrade("algorithms", 68);
        students.get(1).addGrade("programming", 73);
        students.get(1).addGrade("web dev", 82);
        students.get(1).addGrade("maths", 72);
        students.get(1).addGrade("algorithms", 66);
        students.get(2).addGrade("programming", 65);
        students.get(2).addGrade("web dev", 63);
        students.get(2).addGrade("maths", 37);
        students.get(2).addGrade("algorithms", 40);
        students.get(3).addGrade("programming", 55);
        students.get(3).addGrade("web dev", 29);
        students.get(3).addGrade("maths", 56);
        students.get(3).addGrade("algorithms", 38);
        students.get(4).addGrade("programming", 62);
        students.get(4).addGrade("web dev", 51);
        students.get(4).addGrade("maths", 43);
        students.get(4).addGrade("algorithms", 43);
        ///Checks the selected option
        int selection = 0;
       //Loops while selected is not 5
        while(selection != 5) {
            //Print Options
            System.out.println("1: Print Grades\n2; Print Failed\n3: Print Average\n4: Add Student\n5: Quit Program");
            selection = input.nextInt();
            //Switch Statement cases for options selected
            switch(selection) {
                //Print Grades
                case 1 -> {
                    for (Student student : students) {
                        System.out.println(student.getName() + " grades:");

                        for(Grade grade : student.getGradeList()) {
                            System.out.println("\t" + grade.getSubject() + " : " + Grade.getLetterGrade(grade.getScore()));
                        }
                    }
                }
                case 2 -> {
                    //Print students who failed
                    for (Student student : students) {
                        for(Grade grade : student.getGradeList()) {
                            if(Grade.getLetterGrade(grade.getScore()) == 'F') {
                                System.out.println(student.getName() + " is failing a course.");
                                break;
                            }
                        }
                    }
                }
                case 3 -> {
                    //Print Average grade of students
                    for (Student student : students) {
                        int numberOfCourses = student.getGradeList().size();
                        int sumOfNumericGrades = 0;

                        for(Grade grade : student.getGradeList()) {
                            sumOfNumericGrades += grade.getScore();
                        }

                        System.out.println(student.getName() + " has " + (Grade.getLetterGrade(sumOfNumericGrades / numberOfCourses)) + " average.");
                    }
                }
                case 4 -> {
                    //Add a new student
                    System.out.print("Enter student name: ");
                    input.nextLine();
                    String name = input.nextLine();

                    System.out.println("Enter department name: ");
                    String department = input.nextLine();

                    System.out.println("Enter age: ");
                    int age = input.nextInt();

                    System.out.println("Enter student number: ");
                    int studentNumber = input.nextInt();
                    students.add(new Student(name, department, age, studentNumber, true));

                    System.out.println("Input programming grade: ");
                    students.get(students.size() - 1).addGrade("programming", input.nextInt());

                    System.out.println("Input web dev grade: ");
                    students.get(students.size() - 1).addGrade("web dev", input.nextInt());

                    System.out.println("Input maths grade: ");
                    students.get(students.size() - 1).addGrade("maths", input.nextInt());

                    System.out.println("Input algorithms grade: ");
                    students.get(students.size() - 1).addGrade("algorithms", input.nextInt());
                }
            }
        }
    }
}
