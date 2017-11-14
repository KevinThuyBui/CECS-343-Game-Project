package main.cards;

import main.player.Player;
import main.Room;

public class Card27 extends Card {

    Card27() {
        super("Loud Buzzing", 0, 3, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.EAT_CLUB;
    }

    @Override
    protected void success(Player p) {
        String chip = p.chooseChip();
        setSuccessOutcome(p, "1 " + chip + " chip.");
    }

    @Override
    protected void penalty(Player p) {
        p.offsetQuality(-2);
        setFailOutcome(p, "2 Quality Points.");
    }
}
