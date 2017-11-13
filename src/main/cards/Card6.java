package main.cards;

import main.Player;
import main.Room;

public class Card6 extends Card {

    public Card6() {
        super("Exercising Mind and Body", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.REC_CENTER;
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
