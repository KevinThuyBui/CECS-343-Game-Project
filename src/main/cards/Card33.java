package main.cards;

import main.Room;
import main.player.Player;

public class Card33 extends Card {

    Card33() {
        super("Oral Communication", 4, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room.outsideECS()
                && room.isABuilding();
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(4);
        String chip = p.chooseChip();
        setSuccessOutcome(p, "4 Quality Points and 1 " + chip + " chip.");
    }

    @Override
    protected void penalty(Player p) {
        Card discard = p.chooseDiscard();
        setFailOutcome(p, discard + ".");
    }
}
