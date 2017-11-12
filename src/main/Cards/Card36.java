package main.Cards;

import main.Player;
import main.Room;

public class Card36 extends Card {
    public Card36 ()
    {
        filePath = "main/Cards/cardm36.png";
        reward = "3 Quality Points";
    }

    @Override
    void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.NORTH_HALL
                || thisPlayer.getRoom() == Room.SOUTH_HALL
                && thisPlayer.getIntegrety() >= 2)
        {
            thisPlayer.offsetQuality(3);

            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.setRoom(Room.LACTATION_LOUNGE);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
