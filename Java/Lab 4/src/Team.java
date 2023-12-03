public class Team extends Squad {
    //Constructor for teams
    Team(String teamName, Manager manager) {
        super(teamName, manager);
    }
     ///Returns team average
    public double getTeamAverage() {
        double playerAverage = 0;
        for(Player player : getPlayers()) {
            playerAverage += (player.getFitness()
                        + player.getPassingAccuracy()
                        + player.getShotAccuracy()
                        + player.getShotFrequency()
                        + player.getDefensiveness()
                        + player.getAggression()
                        + player.getPositioning()
                        + player.getDribbling()
                        + player.getChanceCreation()
                        + player.getOffsideAdherence()) / 10.0;
        }

        return ((int) (10000.0 * (playerAverage / getPlayers().size()))) / 100.0;
    }
}
