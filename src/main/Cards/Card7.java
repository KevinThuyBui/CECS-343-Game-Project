package main.Cards;

import main.Player;
import main.Room;

public class Card7 extends Card {

    static String oneUp = "integrity";

    public Card7(){
        cardName = "Finding the Lab";
        location = "Elevators";
        reward = "1 Integrity Chip";
        filePath = "main/Cards/cardm07.png";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom()== Room.ELEVATORS) {
            processChipDisplay( thisPlayer, oneUp);                                  //get 1 Integrity chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
