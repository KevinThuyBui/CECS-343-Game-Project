package main.cards;

import main.Player;
import main.Room;

public class Card19 extends Card{

    public Card19(){
        super("Score a Goal", 0, 3, 0);
    }


    @Override
    public boolean canPlay(Room room) {
        return room == Room.GEORGE_ALLEN_FIELD;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(5);
        p.offsetIntegrity(1);
        setSuccessOutcome(p, "5 Quality Points and 1 Integrity Chip.");
    }

    @Override
    protected void penalty(Player p) {
        p.setRoom(Room.STUDENT_PARKING);
        outcome = p + " failed to play " + this + ", teleporting to Student Parking.";
    }
}
