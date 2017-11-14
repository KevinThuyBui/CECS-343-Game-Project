package main.cards;

import main.player.Player;
import main.Room;

public class Card8 extends Card {

    public Card8(){
        super("Enjoying the Peace", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.JAPANESE_GARDEN;
    }

    @Override
    protected void success(Player p) {
        String chip = p.chooseChip(true, false, true);
        setSuccessOutcome(p, 1, chip);
    }

    @Override
    protected void penalty(Player p) {

    }

}
