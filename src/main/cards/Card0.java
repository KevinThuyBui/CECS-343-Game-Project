package main.cards;

import main.player.Player;
import main.Room;

public class Card0 extends Card {

    private static final String oneUp = "learning";

    public Card0() {
        super("CECS 100", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ECS_302 || room == Room.ECS_308;
    }

    @Override
    protected void success(Player p) {
        p.offsetLearning(1);
        setSuccessOutcome(p, "1 Learning Chip.");
    }

    @Override
    protected void penalty(Player p) {

    }
}
