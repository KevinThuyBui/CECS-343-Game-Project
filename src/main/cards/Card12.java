package main.cards;

import main.player.Player;
import main.Room;

public class Card12 extends Card {

    public Card12() {
        super("Late for Class", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room != Room.FORBIDDEN_PARKING;
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
