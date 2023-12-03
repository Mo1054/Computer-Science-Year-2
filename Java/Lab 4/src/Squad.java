import java.util.ArrayList;

public class Squad {
    private String teamName;
    private ArrayList<Player> players;
    private Manager manager;

    Squad(String teamName, Manager manager){
        this.teamName = teamName;
        this.manager = manager;
        players = new ArrayList<>();
    }

    // adds player to player list
    public void addPlayer(Player p){
        players.add(p);
    }

    // get a player object by surname
    public Player getPlayer(String surname){
        for(Player p: players){
            if(p.getSurname().equals(surname)){
                return p;
            }
        }
        return null;
    }

    // get this squads player list
    public ArrayList<Player> getPlayers(){
        return players;
    }

    // get the teams name
    public String getTeamName() {
        return teamName;
    }

    // get the teams manager
    public Manager getManager() {
        return manager;
    }
}
