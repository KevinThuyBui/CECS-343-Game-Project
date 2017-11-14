package main.cards;

import main.player.Player;
import main.Room;

public class Card3 extends Card {

    static String oneUp = "learning";

    public Card3(){
        super("Research Compilers", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.LIBRARY;
    }

    @Override
    protected void success(Player p) {
        p.offsetLearning(1);
        setSuccessOutcome(p, "1 Learning Chip.");
    }

    @Override
    protected void penalty(Player p) {

    }

}
