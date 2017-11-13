package main.cards;

import main.Player;
import main.Room;

public class Card12 extends Card {

    static String oneUp = "craft";

    public Card12(){
        cardName = "Late for Class";
        location = "Any space other than Forbidden Parking";
        reward = "1 Craft Chip";
        imagePath = "main/Cards/cardm12.png";
    }


    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom()!= Room.FORBIDDEN_PARKING) {
            processChipDialog( thisPlayer, oneUp); //get 1 craft Chip
            thisPlayer.setRoom(Room.LACTATION_LOUNGE); //sets player Room
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
