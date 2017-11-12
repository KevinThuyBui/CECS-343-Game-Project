package main.Cards;

import main.Player;
import main.Room;

public class Card32 extends Card {
    public Card32 ()
    {
        filePath = "main/Cards/cardm39.png";
        reward = "10 Quality Points";
    }

    @Override
    void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.STUDENT_PARKING)
        {
            thisPlayer.offsetQuality(10);
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.setRoom(Room.LACTATION_LOUNGE);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
