package main.cards;

import main.Player;
import main.Room;

public class Card18 extends Card {

    public Card18(){
        cardName = "Choosing a Major";
        location = "CECS Conference";
        reward = "5 Quality Points";
        imagePath = "main/Cards/cardm18.png";
    }


    @Override
    public void play(Player thisPlayer) {
        if ((thisPlayer.getRoom()== Room.CECS_CONFERENCE_ROOM) && thisPlayer.getIntegrety() == 3) {
            thisPlayer.offsetQuality(5); //get 1 craft Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(-3);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
