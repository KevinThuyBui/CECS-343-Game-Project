package main.cards;

import main.player.Player;
import main.Room;

public class Card2 extends Card {

    public Card2(){
        super("Lunch at Bratwurst Hall", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.BRATWURST_HALL;
    }

    @Override
    protected void success(Player p) {
        p.offsetCraft(1);
        setSuccessOutcome(p, "1 Craft Chip.");
    }

    @Override
    protected void penalty(Player p) {

    }

}
