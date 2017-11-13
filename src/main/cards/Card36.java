package main.cards;

import main.CardDialog;
import main.ChipDialog;
import main.Player;
import main.Room;

public class Card36 extends Card {
    Card36() {
        super("Make a Friend", 2, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.NORTH_HALL
                || room == Room.SOUTH_HALL;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(3);
        String chip = p.chooseChip();
        setSuccessOutcome(p, "3 Quality Points and 1 " + chip + " chip.");
    }

    @Override
    protected void penalty(Player p) {
        Card discard = new CardDialog().display(p);
        p.discardCard(discard);
        setFailOutcome(p, discard + ".");
    }
}
