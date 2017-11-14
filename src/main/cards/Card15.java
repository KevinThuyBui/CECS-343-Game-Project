package main.cards;

import main.player.Player;
import main.Room;

public class Card15 extends Card {

    public Card15() {
        super("Physics 151", 0, 3, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ECS_308;
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
