package main.cards;

import main.player.Player;
import main.Room;

public class Card38 extends Card {
    Card38() {
        super("Student Parking", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.STUDENT_PARKING;
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
