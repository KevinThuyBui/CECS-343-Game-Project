
package main.cards;

import main.Player;
import main.Room;
import main.ChipDialog;

public class Card1 extends Card {

    String oneUp;

    public Card1() {
        super("Math 122", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.LIBRARY;
    }

    @Override
    protected void success(Player p) {
        String chip = p.chooseChip(true, false, true);
        setSuccessOutcome(p, "1 " + chip + '.');
    }

    @Override
    protected void penalty(Player p) {

    }

}
