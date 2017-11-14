package main.cards;

import main.player.Player;
import main.Room;

public class Card17 extends Card {

    public Card17() {
        super("Learning Netbeans", 0, 0, 3);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.LACTATION_LOUNGE;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(5);
        setSuccessOutcome(p, "5 Quality Points.");
    }

    @Override
    protected void penalty(Player p) {
        p.offsetQuality(-3);
        setFailOutcome(p, "3 Quality Points.");
    }

}
