package main.cards;

import main.Player;
import main.Room;

public class Card0 extends Card {

    static String oneUp = "learning";

    public Card0(){
        cardName = "CECS 100";
        location = "CECS 302 or CECS 308";
        reward = "1 Learning Chip";
        imagePath = "main/Cards/cardm00.png";
    }


    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom()== Room.ECS_302 | thisPlayer.getRoom() == Room.ECS_308) {
            processChipDialog( thisPlayer, oneUp);                                 //get 1 learning Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
