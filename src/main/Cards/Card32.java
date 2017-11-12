package main.Cards;

import main.ChipDialog;
import main.Player;
import main.Room;

public class Card32 extends Card {
    public Card32 ()
    {
        filePath = "main/Cards/cardm32.png";
        reward = "1 Chip";
        cardName = "The Outpost";
    }

    @Override
    void play(Player thisPlayer) {
        if (thisPlayer.getRoom().outsideECS()
                && thisPlayer.getRoom() != Room.FORBIDDEN_PARKING)
        {
            processChipDialog(thisPlayer, new ChipDialog().showDialog(true, true, true));
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
