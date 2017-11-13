package main.Cards;

import main.Player;
import main.Room;

public class Card21 extends Card {

    Card21() {
        filePath = "main/Cards/cardm21.png";
        reward = "5 Quality Points";
        cardName = "Pass Soccer Class";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.GEORGE_ALLEN_FIELD
                && thisPlayer.getCraft() >= 5)
        {
            thisPlayer.offsetQuality(5);
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(3);
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}
