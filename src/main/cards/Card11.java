package main.cards;

import main.player.Player;
import main.Room;

public class Card11 extends Card {

    public Card11(){
        super("Buddy Up", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.EAT_CLUB || room == Room.GEORGE_ALLEN_FIELD;
    }

    @Override
    protected void success(Player p) {
        String chip = p.chooseChip(true, true, false);
        setSuccessOutcome(p, 1, chip);
    }

    @Override
    protected void penalty(Player p) {

    }

}
