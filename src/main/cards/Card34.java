package main.cards;

import main.Player;
import main.Room;

public class Card34 extends Card {
    Card34() {
        super("Chem 111", 0, 6, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room.outsideECS()
                && room.isABuilding();
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(5);
        setSuccessOutcome(p, "5 Quality Points.");
    }

    @Override
    protected void penalty(Player p) {
        p.setRoom(Room.STUDENT_PARKING);
        outcome = p + " failed to play " + this + ", teleporting to Student Parking.";
    }

}
