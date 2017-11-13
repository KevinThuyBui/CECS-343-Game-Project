package main.Cards;

import main.ChipDialog;
import main.Player;
import main.Room;

public class Card35 extends Card {
    Card35()
    {
        cardName = "Learning Linux";
        filePath = "main/Cards/cardm35.png";
        reward = "3 Quality Points and a chip";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.COMPUTER_LAB)
        {
            thisPlayer.offsetQuality(3);
            processChipDialog(thisPlayer, new ChipDialog().showDialog(true, true, true));
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            thisPlayer.offsetQuality(-1);
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
