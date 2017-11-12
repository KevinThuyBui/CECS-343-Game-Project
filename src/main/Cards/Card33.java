package main.Cards;

import main.CardDialog;
import main.ChipDialog;
import main.Player;
import main.Room;

public class Card33 extends Card {
    Card33()
    {
        cardName = "Oral Communication";
        filePath = "main/Cards/cardm33.png";
        reward = "4 Quality Points and a chip";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().outsideECS()
                && thisPlayer.getRoom().isABuilding()
                && thisPlayer.getIntegrety() >= 4)
        {
            thisPlayer.offsetQuality(4);
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
