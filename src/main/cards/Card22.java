package main.cards;

import main.player.Player;
import main.Room;

public class Card22 extends Card {

    Card22() {
        super("Fall in the Pond", 0, 0, 3);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.JAPANESE_GARDEN;
    }

    @Override
    protected void success(Player p) {
        p.offsetIntegrity(1);
        p.offsetCraft(1);
        setSuccessOutcome(p, "1 Integrity Chip and 1 Craft Chip.");
    }

    @Override
    protected void penalty(Player p) {
        p.setRoom(Room.LACTATION_LOUNGE);
        outcome = p + " failed to play " + this + ", teleporting to the Lactation Lounge.";
    }
}
