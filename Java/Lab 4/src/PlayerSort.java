import java.util.ArrayList;

public class PlayerSort implements Comparator{


    @Override
    public ArrayList<Player> sortPlayers(Squad squad) {
        //Clone the sqaud arraylist players
        ArrayList < Player > unsorted = (ArrayList < Player > ) squad.getPlayers().clone();
        ArrayList < Player > sorted = new ArrayList < > ();
        //Goes through the unsorted players arraylist
        for (int i = 0; i < unsorted.size(); i++) {
            Player player = unsorted.get(i);
            //Compares the players then sorts them into player
            for (int j = 0; j < unsorted.size(); j++) {
                if (player.getPlayerAverage() < unsorted.get(j).getPlayerAverage()) {
                    player = unsorted.get(j);
                }
            }

            i--;
            //remove players from unsorted
            unsorted.remove(player);
            //adds players to sorted
            sorted.add(player);
        }
        //Return sorted players
        return sorted;

    }
}
