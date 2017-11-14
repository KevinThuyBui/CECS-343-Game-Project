package main.cards;

import main.Room;
import main.player.Player;

public class Card9 extends Card {

    static String oneUp = "learning";

    public Card9() {
        super("Parking Violation", 0, 0, 0);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.FORBIDDEN_PARKING;
    }

    @Override
    protected void success(Player p) {
        p.offsetLearning(1);
        if (!p.getHand().isEmpty()) {
            Card card = p.chooseDiscard();
            p.offsetLearning(1);
            setSuccessOutcome(p, "2 Learning Chips and discard " + card.getCardName() + ".");
        } else {
            setSuccessOutcome(p, 1, "Learning");
        }
    }

    @Override
    protected void penalty(Player p) {

    }
}
