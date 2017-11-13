package main.cards;

import main.ChipDialog;
import main.Player;
import main.Room;

public class Card35 extends Card {
    Card35() {
        super("Learning Linux", 3, 2, 0);
    }


    @Override
    public boolean canPlay(Room room) {
        return room == Room.COMPUTER_LAB;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(3);
        String chip = p.chooseChip();
        setSuccessOutcome(p, "3 Quality Points and 1 " + chip + " chip.");
    }

    @Override
    protected void penalty(Player p) {
        p.offsetQuality(-1);
        setFailOutcome(p, "1 Quality Point.");
    }
}
