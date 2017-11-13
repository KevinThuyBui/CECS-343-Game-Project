package main.cards;

import main.Player;
import main.Room;

public class Card37 extends Card {

    Card37()
    {
        cardName = "Enjoying Nature";
        imagePath = "main/Cards/cardm37.png";
        reward = "1 Craft Chip";
    }

    @Override
    public void play(Player thisPlayer) {
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
