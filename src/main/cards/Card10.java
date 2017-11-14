package main.cards;

import main.player.Player;
import main.Room;

public class Card10 extends Card {

    public Card10() {
        super("CECS 105", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ECS_302 || room == Room.ECS_308;
    }

    @Override
    protected void success(Player p) {
        p.offsetLearning(1);
        setSuccessOutcome(p, 1, "Learning");
    }

    @Override
    protected void penalty(Player p) {

    }
}
