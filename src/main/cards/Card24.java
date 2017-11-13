package main.cards;

import main.CardDialog;
import main.Player;
import main.Room;

public class Card24 extends Card {

    Card24() {
        imagePath = "main/Cards/cardm24.png";
        reward = "5 Quality Points and a Card";
        cardName = "Meet the Dean";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.NORTH_HALL
                && thisPlayer.getRoom() == Room.SOUTH_HALL
                && thisPlayer.getIntegrety() >= 3
                && thisPlayer.getLearning() >= 3
                && thisPlayer.getCraft() >= 3)
        {
            thisPlayer.offsetQuality(5);
            thisPlayer.draw();
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.discardCard(new CardDialog().display(thisPlayer));
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}
