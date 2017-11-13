package main.cards;

import main.ChipDialog;
import main.Player;
import main.Room;

public class Card32 extends Card {
    Card32()
    {
        super("The Outpost", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room.outsideECS()
                && room != Room.FORBIDDEN_PARKING;
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
