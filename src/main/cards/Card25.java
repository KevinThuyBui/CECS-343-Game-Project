package main.cards;

import main.CardDialog;
import main.ChipDialog;
import main.Player;
import main.Room;

public class Card25 extends Card {

    Card25() {
        imagePath = "main/Cards/cardm25.png";
        reward = "5 Quality Points and a Chip";
        cardName = "Program Crashes";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.LACTATION_LOUNGE
                && thisPlayer.getLearning() >= 2)
        {
            thisPlayer.offsetQuality(5);
            processChipDialog(thisPlayer, new ChipDialog().showDialog(true,true,true));
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.discardCard(new CardDialog().display(thisPlayer));
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}
