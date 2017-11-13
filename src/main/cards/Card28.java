package main.cards;

import main.CardDialog;
import main.ChipDialog;
import main.Player;
import main.Room;

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
        Card discard = new CardDialog().display(p);
        p.discardCard(discard);
        setFailOutcome(p, discard + ".");
    }
}
