package main.cards;

import main.player.Player;
import main.Room;

public class Card21 extends Card {

    Card21() {
        super("Pass Soccer Class", 0, 5, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.GEORGE_ALLEN_FIELD;
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
