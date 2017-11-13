package main.cards;

import main.Player;
import main.Room;

public class Card22 extends Card {

    Card22() {
        imagePath = "main/Cards/cardm22.png";
        reward = "1 Integrity and 1 Craft Chip";
        cardName = "Fall in the Pond";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.JAPANESE_GARDEN
                && thisPlayer.getLearning() >= 3)
        {
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.setRoom(Room.LACTATION_LOUNGE);
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}