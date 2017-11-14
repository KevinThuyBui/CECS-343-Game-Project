package main.cards;

import main.Room;
import main.player.Player;

public class Card25 extends Card {

    Card25() {
        super("Program Crashes", 0, 0, 2);
    }


    @Override
    public boolean canPlay(Room room) {
        return room == Room.LACTATION_LOUNGE;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(5);
        String chip = p.chooseChip();
        setSuccessOutcome(p, "5 Quality Points and 1 " + chip + " chip.");
    }

    @Override
    protected void penalty(Player p) {
        Card discard = p.chooseDiscard();
        setFailOutcome(p, discard + ".");
    }
}
