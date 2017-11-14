package main.cards;

import main.Room;
import main.player.Player;

public class Card28 extends Card {

    Card28() {
        super("Professor Englert", 3, 0, 0);
    }

    public boolean canPlay(Room room) {
        return room == Room.CECS_CONFERENCE_ROOM;
    }

    @Override
    protected void success(Player p) {
        String chip = p.chooseChip();
        setSuccessOutcome(p, "1 " + chip + " chip.");
    }

    @Override
    protected void penalty(Player p) {
        Card discard = p.chooseDiscard();
        setFailOutcome(p, discard + ".");
    }
}
