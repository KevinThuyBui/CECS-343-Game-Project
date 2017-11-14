package main.cards;

import main.Room;
import main.player.Player;

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
        Card discard = p.chooseDiscard();
        setFailOutcome(p, discard + ".");
    }
}
