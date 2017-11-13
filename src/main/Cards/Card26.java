package main.Cards;

import main.Player;
import main.Room;

public class Card26 extends Card {

    Card26() {
        filePath = "main/Cards/cardm26.png";
        reward = "2 Craft Chips";
        cardName = "Press the Right Floor";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.ELEVATORS
                && thisPlayer.getLearning() >= 4)
        {
            thisPlayer.offsetCraft(2);
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(2);
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}
