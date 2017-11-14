package main.cards;

import main.player.Player;
import main.Room;

public class Card29 extends Card {

    Card29() {
        super("Soccer Goalie", 0, 3, 3);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.GEORGE_ALLEN_FIELD;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(5);
        p.drawCard();
        setSuccessOutcome(p, "5 Quality Points and a card.");
    }

    @Override
    protected void penalty(Player p) {
        p.setRoom(Room.STUDENT_PARKING);
        outcome = p + " failed to play " + this + ", teleporting to Student Parking.";
    }
}
