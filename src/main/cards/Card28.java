package main.cards;

import main.CardDialog;
import main.ChipDialog;
import main.Player;
import main.Room;

public class Card28 extends Card {

    Card28() {
        imagePath = "main/Cards/cardm28.png";
        reward = "1 Chip";
        cardName = "Professor Englert";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.CECS_CONFERENCE_ROOM)
        {
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
