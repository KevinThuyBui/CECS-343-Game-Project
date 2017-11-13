package main.cards;

import main.Player;
import main.Room;

public class Card37 extends Card {

    Card37() {
        super("Enjoying Nature", 0, 0, 0);
    }


    @Override
    public boolean canPlay(Room room) {
        return room.outsideECS();
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
