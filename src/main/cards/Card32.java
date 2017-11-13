package main.cards;

import main.ChipDialog;
import main.Player;
import main.Room;

public class Card32 extends Card {
    Card32()
    {
        imagePath = "main/Cards/cardm32.png";
        reward = "1 Chip";
        cardName = "The Outpost";
    }

    @Override
    public void play(Player thisPlayer) {
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
