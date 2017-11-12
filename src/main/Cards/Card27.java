package main.Cards;

import main.ChipDialog;
import main.Player;
import main.Room;

public class Card27 extends Card {

    public Card27() {
        filePath = "main/Cards/cardm27.png";
        reward = "1 Chip";
        cardName = "Loud Buzzing";
    }

    @Override
    void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.EAT_CLUB
                && thisPlayer.getCraft() >= 3)
        {
            processChipDialog(thisPlayer, new ChipDialog().showDialog(true, true, true));
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(-2);
            outcome = failedOutcomeString(thisPlayer.getName());
        }

    }
}
