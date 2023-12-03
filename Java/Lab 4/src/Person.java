public class Person {
    //variables for person
    private String firstName;
    private String surname;
    private String team;

    //Constructor for person
    public Person(String firstName, String surname, String team) {
        this.firstName = firstName;
        this.surname = surname;
        this.team = team;
    }

    //Getters and Setters for variables of person
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
