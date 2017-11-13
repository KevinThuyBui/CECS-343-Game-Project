package main.cards;

import main.Player;
import main.Room;

public class Card30 extends Card {
    Card30() {
        super("Elective Class", 0, 0, 2);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.LIBRARY;
    }

    @Override
    protected void success(Player p) {
        p.offsetLearning(1);
        p.drawCard();
        setSuccessOutcome(p, "1 Learning Chip and 1 Game Card.");
    }

    @Override
    protected void penalty(Player p) {
        p.offsetQuality(-2);
        setFailOutcome(p, "2 Quality Points.");
    }
}
