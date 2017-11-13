package main.cards;

import main.Player;
import main.Room;

public class Card3 extends Card {

    static String oneUp = "learning";

    public Card3(){
        cardName = "Research Compilers";
        location = "Library";
        reward = "1 Learning Chip";
        imagePath = "main/Cards/cardm03.png";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.LIBRARY) {
            processChipDialog( thisPlayer, oneUp);                                 //get 1 learning Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
