package main.Cards;

import main.Player;
import main.Room;

public class Card13 extends Card{

    static String oneUp = "craft";

    public Card13(){
        cardName = "The Big Game";
        location = "Pyrimad";
        reward = "1 Craft Chip and Teleport to Lactation Lounge";
        filePath = "main/Cards/cardm13.png";
    }


    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom()== Room.PYRAMID) {
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
