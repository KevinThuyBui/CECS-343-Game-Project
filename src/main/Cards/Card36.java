package main.Cards;

import main.CardDialog;
import main.ChipDialog;
import main.Player;
import main.Room;

public class Card36 extends Card {
    Card36()
    {
        cardName = "Make a Friend";
        filePath = "main/Cards/cardm36.png";
        reward = "3 Quality Points and a chip";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.NORTH_HALL
                || thisPlayer.getRoom() == Room.SOUTH_HALL
                && thisPlayer.getIntegrety() >= 2)
        {
            thisPlayer.offsetQuality(3);
            processChipDialog(thisPlayer, new ChipDialog().showDialog(true, true, true));
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.discardCard(new CardDialog().display(thisPlayer));
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
