package main.cards;

import main.Player;
import main.Room;

public class Card19 extends Card{

    public Card19(){
        cardName = "Score a Goal";
        location = "George Allen Field";
        reward = "5 Quality Points and 1 Integrity Chip";
        imagePath = "main/Cards/cardm19.png";
    }


    @Override
    public void play(Player thisPlayer) {
        if ((thisPlayer.getRoom()== Room.GEORGE_ALLEN_FIELD) && thisPlayer.getCraft() == 3) {
            thisPlayer.offsetQuality(5); //get 1 craft Chip
            thisPlayer.offsetIntegrity(1);
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.setRoom(Room.STUDENT_PARKING);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
