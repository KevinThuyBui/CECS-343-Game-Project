package main.cards;

import main.CardDialog;
import main.ChipDialog;
import main.Player;
import main.Room;

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
        Card discard = new CardDialog().display(p);
        p.discardCard(discard);
        setFailOutcome(p, discard + ".");
    }
}
