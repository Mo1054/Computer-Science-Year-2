import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static Squad[] squads = new Squad[32];

    public static void main(String[] args) {
        // Arraylists for player and managers
        ArrayList < Player > players = new ArrayList < > ();
        ArrayList < Manager > manager = new ArrayList < > ();

        try {
            // Call files
            File playersFile = new File("Players.csv");
            Scanner playersScanner = new Scanner(playersFile);

            File managersFile = new File("Managers.csv");
            Scanner managersScanner = new Scanner(managersFile);

            // Skip the header rows
            playersScanner.nextLine();
            managersScanner.nextLine(); // ignore header row

            // Going through player file
            while (playersScanner.hasNextLine()) {
                // Split player data
                String[] playerData = playersScanner.nextLine().split("\\,");

                // Create a new player object using the playerData array
                Player player = new Player(playerData[3], Double.parseDouble(playerData[4]), Double.parseDouble(playerData[5]), Double.parseDouble(playerData[6]), Double.parseDouble(playerData[7]), Double.parseDouble(playerData[8]), Double.parseDouble(playerData[9]), Double.parseDouble(playerData[10]), Double.parseDouble(playerData[11]), Double.parseDouble(playerData[12]), Double.parseDouble(playerData[13]), playerData[0], playerData[1], playerData[2]);

                // Add the player to array list
                players.add(player);
            }
            // Going through manager file
            while (managersScanner.hasNextLine()) {
                // Split manager
                String[] managerData = managersScanner.nextLine().split("\\,");

                // Create a new manager object using manager data
                Manager managers = new Manager(managerData[3], Double.parseDouble(managerData[4]), Double.parseDouble(managerData[5]), Double.parseDouble(managerData[6]), Double.parseDouble(managerData[7]), managerData[0], managerData[1], managerData[2]);

                // Add the manager to the arraylist
                manager.add(managers);
            }

            playersScanner.close();
            managersScanner.close();
        } catch (FileNotFoundException e) {
            // Catch the error
            System.out.println("Players.csv file not found.");
        }

        // Adding managers to squad
        for (int i = 0; i < squads.length; i++) {
            Manager m = manager.get(i);
            squads[i] = new Squad(m.getTeam(), m);
        }

        // Adds each player to their respective team
        for (int i = 0; i < squads.length; i++) {
            for (int j = 0; j < players.size(); j++) {

                Player p = players.get(j);

                String playerTeams = p.getTeam();
                String managerTeams = squads[i].getManager().getTeam();
                if (managerTeams.equals(playerTeams)) {

                    squads[i].addPlayer(p);
                }


            }
        }

        runTournament();
    }

    public static Team getTeam(Squad squad) {
        //Crate new team
        Team team = new Team(squad.getTeamName(), squad.getManager());
        //Get favored formation of the manager
        String[] formation = (team.getManager().getFavouredFormation() + "-1").split("-");
        //Formation options
        String[] formationOptions = {
                "Defender",
                "Midfielder",
                "Forward",
                "Goal Keeper"
        };
        //Call playerSort class
        PlayerSort sort = new PlayerSort();
        //Get sorted Players
        ArrayList < Player > player = sort.sortPlayers(squad);
        //Loop through formation array and find players that match
        for (int i = 0; i < formation.length; i++) {
            //Finding the limit from the formation arraylist
            int limit = Integer.parseInt(formation[i]);
            int foundPlayers = 0;
            //Adding players to the team using the sortedplayers arraylist
            for (int j = 0; j < player.size(); j++)
                //Checking the arraylist contains the right formation
                if (player.get(i).getPosition().contains(formationOptions[i])) {
                    team.addPlayer(player.get(i));
                    foundPlayers++;
                }
            //breaks if limit is reached
            if (foundPlayers == limit) {
                break;
            }
        }

        return team;
    }

    public static void runTournament() {
        ///Create arraylists
        ArrayList < ArrayList < Team >> groups = new ArrayList < > ();
        ArrayList < Team > team = new ArrayList < > ();

        //Loop through sqauds and adding groups to teams.
        for (int i = 0; i < squads.length; i++) {
            if (i > 0 && i % 4 == 0) {
                groups.add(team);
                team = new ArrayList < > ();
            }
            //Getting the squads using the getTeams function
            team.add(getTeam(squads[i]));
        }

        //Uses Groupwinner function to determine the winning team
        Team firstTeam = getGroupWinner(new ArrayList < > (Arrays.asList(getGroupWinner(groups.get(0)), getGroupWinner(groups.get(1)))));
        Team secondTeam = getGroupWinner(new ArrayList < > (Arrays.asList(getGroupWinner(groups.get(2)), getGroupWinner(groups.get(3)))));

        ///Compares team averages and decides who won the world cup
        if (firstTeam.getTeamAverage() > secondTeam.getTeamAverage()) {

            System.out.println(firstTeam.getTeamName() + " has won the World Cup!");
        } else {

            System.out.println(secondTeam.getTeamName() + " has won the World Cup!");
        }
    }

    public static Team getGroupWinner(ArrayList < Team > group) {
        //Sets the winning team at group index 0
        Team winningTeam = group.get(0);
        //random integers
        int luckFirstBonus = (int)(Math.random() * 11);
        int luckSecondBonus = (int)(Math.random() * 11);

        //Goes through the groups arraylist and find the winning team by comparing team averages plus randomness
        for (int i = 1; i < group.size(); i++) {
            if (winningTeam.getTeamAverage() + luckFirstBonus < group.get(i).getTeamAverage() + luckSecondBonus) {
                winningTeam = group.get(i);
            }
        }
        //return team
        return winningTeam;
    }

}