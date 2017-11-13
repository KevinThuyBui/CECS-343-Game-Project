package main.cards;

import main.CardDialog;
import main.Player;
import main.Room;

public class Card39 extends Card {
    Card39() {
        super("Goodbye, Professor", 6, 6, 6);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ROOM_OF_RETIREMENT;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(10);
        setSuccessOutcome(p, "10 Quality Points.");
    }

    @Override
    protected void penalty(Player p) {
        Card discard = new CardDialog().display(p);
        p.discardCard(discard);
        setFailOutcome(p, discard + ".\nGame Card \"Goodbye, Professor\" has been dropped in the Room of Retirement");
    }
}
