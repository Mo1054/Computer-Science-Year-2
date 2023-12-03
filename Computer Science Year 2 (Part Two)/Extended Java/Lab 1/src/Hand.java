import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
    private ArrayList < Card > hand = new ArrayList < > ();
    private final String[] ranks = {
            "Royal Flush",
            "Straight Flush",
            "4-of-a-kind",
            "Full House",
            "Flush",
            "Straight",
            "3-of-a-kind",
            "2 Pair",
            "1 Pair",
            "High Card"
    };

    private final int numValues = 15;

    public void addCard(Card c) {
        if (hand.size() < 5) {
            hand.add(c);
        }
    }

    public String getHandRank() {
        if (hand.size() != 5) {
            return "Incorrect hand size";
        }
        //sort the hand
        hand.sort(new SortCards());

        //high card (None of the other hands match, the highest value of the card)

        //one pair ( a pair of cards with the same value e.g. 7D, 7H, 4S, 6H, 8H)

        //two pair (2 pairs of matched values e.g. 7D, 7H, 4S, 4C, 2D)
        //

        //3 of a kind (3 cards with the same value and two others e.g. 7D, 7H, 7C, 2H, KS)

        //straight (A run of values in different suits e.g. 3H, 4D, 5H, 6C, 7S)

        //flush (All cards are in the same suit e.g. 3H, 7H, 9H, JH, KH)

        //full house (3 of a kind and a pair e.g. 7S, 7H, 7D, 4C, 4H)

        //4 of a kind (4 cards with the same value e.g. 9S, 9C, 9H, 9D, 7D)

        //straight flush (5 cards in a row all of the same suit e.g. 3S, 4S, 5S, 6S, 7S)

        //royal flush (J,Q,K,A,10 all of the same suit)

        if (isRoyalFlush()) {

            return ranks[0];
        } else if (isStraight() && isFlush()) {

            return ranks[1];
        } else if (isFourOfAKind()) {

            return ranks[2];
        } else if (isThreeOfAKind() && onePair()) {

            return ranks[3];
        } else if (isFlush()) {

            return ranks[4];
        } else if (isStraight()) {

            return ranks[5];
        } else if (isThreeOfAKind()) {

            return ranks[6];
        } else if (isTwoPairs()) {

            return ranks[7];
        } else if (onePair()) {

            return ranks[8];

        }

        return ranks[9];
    }
    //Create the frequency of cards array
    public int[] getFrequency() {
        int[] frequency = new int[15];
        for (int i = 0; i < 5; i++) {
            int rank = hand.get(i).getNumericValue();
            frequency[rank]++;
        }
        return frequency;
    }
    //Check if one pair exists
    private boolean onePair() {
        int[] frequency = getFrequency();
        for (int i = 0; i < numValues; i++) {
            if (frequency[i] == 2) {
                return true;
            }
        }
        return false;
    }
    //Check if 1 pair exists.
    private boolean isTwoPairs() {
        int numPairs = 0;
        int[] frequency = getFrequency();
        for (int i = 0; i < numValues; i++) {
            if (frequency[i] == 2) {
                numPairs++;
            }
        }
        return numPairs == 2;
    }
    //check if 3 cards have the same value
    private boolean isThreeOfAKind() {
        int[] frequency = getFrequency();
        for (int i = 0; i < numValues; i++) {
            if (frequency[i] == 3) {
                return true;
            }
        }
        return false;
    }
    /// check if 4 cards have the same value
    private boolean isFourOfAKind() {
        int[] frequency = getFrequency();
        for (int i = 0; i < numValues; i++) {
            if (frequency[i] == 4) {
                return true;
            }
        }
        return false;
    }
    //Check all suits are the same
    private boolean isFlush() {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getSuit() != hand.get(i + 1).getSuit()) {
                return false;
            }
        }
        return true;
    }

    // isStraight function for finding suits in sequential order
    private boolean isStraight() {
        int[] frequency = getFrequency();

        // Check for special case of Ace-low straight (A, 2, 3, 4, 5)
        if (frequency[2] == 1 && frequency[3] == 1 && frequency[4] == 1 && frequency[5] == 1 && frequency[14] == 1) {
            return true;
        }
        //Check if suits in the frequency are in sequential order
        for (int i = 0; i < 10; i++) {
            if (frequency[i] == 1 && frequency[i + 1] == 1 && frequency[i + 2] == 1 && frequency[i + 3] == 1 && frequency[i + 4] == 1) {
                return true;
            }
        }

        return false;
    }
    //Check if a royal has been achieved
    private boolean isRoyalFlush() {
        int[] frequency = getFrequency();

        if (frequency[10] == 1 && frequency[11] == 1 && frequency[12] == 1 && frequency[13] == 1 && frequency[14] == 1) {
            if (isFlush()) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String output = "";
        for (Card c: hand) {
            if (c.getSuit().equals("Hearts") || c.getSuit().equals("Diamonds")) {
                output += "\u001B[31m[ " + c.getValue() + " , " + c.getSuit() + " ] \u001B[0m";
            } else {
                output += "[ " + c.getValue() + " , " + c.getSuit() + " ] ";
            }
        }

        return output;
    }
}