package main.Cards;

import main.Player;
import main.Room;

public class Card4 extends Card {

    static String oneUp = "learning";

    public Card4(){
        cardName = "Professor Murgolo's CECS 174 Class";
        location = "ECS 302";
        reward = "1 Learning Chip";
        filePath = "main/Cards/cardm04.png";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.ECS_302) {
            processChipDialog( thisPlayer, oneUp);                                 //get 1 learning Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
