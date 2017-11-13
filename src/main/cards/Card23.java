package main.cards;

import main.CardDialog;
import main.ChipDialog;
import main.Player;
import main.Room;

public class Card23 extends Card {

    Card23() {
        imagePath = "main/Cards/cardm23.png";
        reward = "3 Quality Points and a Chip";
        cardName = "A New Laptop";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.COMPUTER_LAB
                && thisPlayer.getIntegrety() >= 4)
        {
            thisPlayer.offsetQuality(3);
            processChipDialog(thisPlayer, new ChipDialog().showDialog(true, true, true));
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.discardCard(new CardDialog().display(thisPlayer, this));
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}
