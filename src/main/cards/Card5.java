package main.cards;

import main.player.Player;
import main.Room;

public class Card5 extends Card {

    static String oneUp = "craft";

    public Card5(){
        super("CECS 100", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ECS_308;
    }

    @Override
    protected void success(Player p) {
        p.offsetCraft(1);
        setSuccessOutcome(p, "1 Craft Chip.");
    }

    @Override
    protected void penalty(Player p) {

    }
}
