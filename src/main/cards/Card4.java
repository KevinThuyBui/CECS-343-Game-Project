package main.cards;

import main.player.Player;
import main.Room;

public class Card4 extends Card {

    public Card4(){
        super("Professor Murgolo's CECS 174 Class", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ECS_302;
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
