package main.Cards;

import main.Player;
import main.Room;

public class Card37 extends Card {
    public Card37 ()
    {
        cardName = "Enjoying Nature";
        filePath = "main/Cards/cardm37.png";
        reward = "1 Craft Chip";
    }

    @Override
    void play(Player thisPlayer) {
        if (thisPlayer.getRoom().outsideECS())
        {
            thisPlayer.offsetCraft(1);
            thisPlayer.setRoom(Room.LACTATION_LOUNGE);
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }


}
