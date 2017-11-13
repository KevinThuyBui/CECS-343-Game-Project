package main.Cards;

import main.Player;
import main.Room;

public class Card2 extends Card {

    static String oneUp = "craft";

    public Card2(){
        cardName = "Lunch at Bratwurst Hall";
        location = "Bratwurst Hall";
        reward = "1 Craft Chip";
        filePath = "main/Cards/cardm02.png";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom()== Room.BRATWURST_HALL) {           //played at Bratwurst Hall
            processChipDisplay( thisPlayer, oneUp);     //get 1 Craft Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else{
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
