package main.cards;

import main.Player;
import main.Room;

public class Card38 extends Card {
    Card38()
    {
        cardName = "Student Parking";
        imagePath = "main/Cards/cardm38.png";
        reward = "1 Quality Chip";
    }
    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.STUDENT_PARKING)
        {
            thisPlayer.offsetQuality(1);
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.setRoom(Room.LACTATION_LOUNGE);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
