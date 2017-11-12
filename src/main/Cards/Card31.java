package main.Cards;

import main.Player;
import main.Room;

public class Card31 extends Card {
    public Card31 ()
    {
        cardName = "Professor Hoffman";
        filePath = "main/Cards/cardm31.png";
        reward = "5 Quality Points and 2 cards";
    }

    @Override
    void play(Player thisPlayer) {
        if (!thisPlayer.getRoom().outsideECS()
                && thisPlayer.getRoom() != Room.LACTATION_LOUNGE
                && thisPlayer.getLearning() >= 3)
        {
            thisPlayer.offsetQuality(5);
            thisPlayer.draw();
            thisPlayer.draw();
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(-5);
            thisPlayer.setRoom(Room.LACTATION_LOUNGE);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
