package main.cards;

import main.player.Player;
import main.Room;

public class Card7 extends Card {


    public Card7() {
        super("Finding the Lab", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ELEVATORS;
    }

    @Override
    protected void success(Player p) {
        p.offsetIntegrity(1);
        setSuccessOutcome(p, "1 Integrity Chip.");
    }

    @Override
    protected void penalty(Player p) {

    }
}
