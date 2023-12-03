public class Manager extends Person {
    //variables for manager
    private String favouredFormation;
    private double respect;
    private double ability;
    private double knowledge;
    private double belief;

    //Constructor for manager
    public Manager(String favouredFormation, double respect, double ability, double knowledge, double belief, String name, String surname, String team) {
        super(name, surname, team);
        this.favouredFormation = favouredFormation;
        this.respect = respect;
        this.ability = ability;
        this.knowledge = knowledge;
        this.belief = belief;
    }

    //Getters and Setters for variables
    public String getFavouredFormation() {
        return favouredFormation;
    }

    public void setFavouredFormation(String favouredFormation) {
        this.favouredFormation = favouredFormation;
    }

    public double getRespect() {
        return respect;
    }

    public void setRespect(double respect) {
        this.respect = respect;
    }

    public double getAbility() {
        return ability;
    }

    public void setAbility(double ability) {
        this.ability = ability;
    }

    public double getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(double knowledge) {
        this.knowledge = knowledge;
    }

    public double getBelief() {
        return belief;
    }

    public void setBelief(double belief) {
        this.belief = belief;
    }


}
