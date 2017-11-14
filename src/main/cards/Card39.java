package main.cards;

import main.Room;
import main.player.Player;

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
        Card discard = p.chooseDiscard();
        setFailOutcome(p, discard + ".\nGame Card \"Goodbye, Professor\" has been dropped in the Room of Retirement");
    }
}
