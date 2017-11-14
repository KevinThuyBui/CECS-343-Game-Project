package main.cards;

import main.player.Player;
import main.Room;

public class Card31 extends Card {
    Card31()
    {
        super("Professor Hoffman", 0, 0, 3);
    }

    @Override
    public boolean canPlay(Room room) {
        return !room.outsideECS()
                && room != Room.LACTATION_LOUNGE
                && room != Room.NORTH_HALL
                && room != Room.SOUTH_HALL;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(5);
        p.drawCard();
        p.drawCard();
        setSuccessOutcome(p, "5 Quality Points and 2 Game Cards.");
    }

    @Override
    protected void penalty(Player p) {
        p.setRoom(Room.LACTATION_LOUNGE);
        p.offsetQuality(-5);
        outcome = p + " failed to play " + this + ", losing 5 Quality Points and teleporting to the Lactation Lounge.";
    }
}
