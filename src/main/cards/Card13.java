package main.cards;

import main.Player;
import main.Room;

public class Card13 extends Card {

    static String oneUp = "craft";

    public Card13() {
        super("The Big Game", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.PYRAMID;
    }

    @Override
    protected void success(Player p) {
        p.offsetCraft(1);
        p.setRoom(Room.LACTATION_LOUNGE);
        setSuccessOutcome(p, "1 Craft and Teleports to the Lactation Lounge");
    }

    @Override
    protected void penalty(Player p) {

    }

}
