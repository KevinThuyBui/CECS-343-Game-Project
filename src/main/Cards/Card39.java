package main.Cards;

import main.CardDialog;
import main.Player;
import main.Room;

public class Card39 extends Card {
    public Card39()
    {
        filePath = "main/Cards/cardm39.png";
    }
    @Override
    void play(Player thisPlayer) {
        if (thisPlayer.getRoom() == Room.ROOM_OF_RETIREMENT
                && thisPlayer.getIntegrety() >= 6
                && thisPlayer.getCraft() >= 6
                && thisPlayer.getLearning() >= 6)
        {
            thisPlayer.offsetQuality(10);
        }
        else
        {
            thisPlayer.discardCard(new CardDialog().display(thisPlayer));
        }
    }
}
