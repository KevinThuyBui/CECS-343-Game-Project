package main.cards;

import main.Player;
import main.Room;

public class Card26 extends Card {

    Card26() {
        super("Press the Right Floor", 0, 0, 4);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ELEVATORS;
    }

    @Override
    protected void success(Player p) {
        p.offsetCraft(2);
        setSuccessOutcome(p, 2, "Craft");
    }

    @Override
    protected void penalty(Player p) {
        p.offsetQuality(-2);
        setFailOutcome(p, "2 Quality Points.");
    }
}
