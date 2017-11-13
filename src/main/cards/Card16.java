package main.cards;

import main.Player;
import main.Room;

public class Card16 extends Card {

    public Card16() {
        super("KIN 253 Learning the Rules of Soccer", 4, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.GEORGE_ALLEN_FIELD;
    }

    @Override
    protected void success(Player p) {
        p.offsetCraft(2);
        setSuccessOutcome(p, 2, "Craft");
    }

    @Override
    protected void penalty(Player p) {
        p.setRoom(Room.ROOM_OF_RETIREMENT);
        outcome = p + " failed to play " + this + ", teleporting to the Room of Retirement.";
    }

}
