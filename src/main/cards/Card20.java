package main.cards;

import main.player.Player;
import main.Room;

public class Card20 extends Card {

    Card20() {
        super("Make the Dean's List", 0, 0, 6);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.GEORGE_ALLEN_FIELD;
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
