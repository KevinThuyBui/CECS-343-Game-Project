package main.Cards;

import main.Player;
import main.Room;

public class Card5 extends Card {

    static String oneUp = "craft";

    public Card5(){
        cardName = "CECS 100";
        location = "ECS 308";
        reward = "1 Craft Token";
        filePath = "main/Cards/cardm05.png";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.ECS_308) {
            processChipDialog( thisPlayer, oneUp);                                   //get 1 craft token
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
