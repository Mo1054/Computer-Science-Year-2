import java.io.*;
import java.util.*;

public class CardMain {
    public static void main(String[] args) {
        Deck d = new Deck(true);
//        System.out.println(d);

        Hand h = new Hand();
        for(int i = 0; i<5; i++) {
            h.addCard(d.deal());
        }
        System.out.println(h.getHandRank());
        System.out.println(h);


    }
}
