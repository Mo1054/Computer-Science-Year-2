public class Grade {
    private String subject;
    private double score;
    //Constructor that sets score and subject
    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }
    //Get subject
    public String getSubject() {
        return subject;
    }
    //Set Subject
    public void setSubject(String subject) {
        this.subject = subject;
    }
    //Get score
    public double getScore() {
        return score;
    }
    //Set score
    public void setScore(int score) {
        this.score = score;
    }
   //Method that returns grade based on score
    public static char getLetterGrade(double score) {
        if(score > 100) {
            return 'E';
        } else if(score >= 70) {
            return 'A';
        } else if(score >= 60) {
            return 'B';
        } else if(score >= 50) {
            return 'C';
        } else if(score >= 40) {
            return 'D';
        } else if(score >= 0){
            return 'F';
        }

        return 'E';
    }
}
