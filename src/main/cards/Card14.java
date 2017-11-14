package main.cards;

import main.Room;
import main.player.Player;

public class Card14 extends Card {

    public Card14() {
        super("Math 123", 0, 0, 5);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ECS_302 || room == Room.ECS_308;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(5);
        setSuccessOutcome(p, "5 Quality Points.");
    }

    @Override
    protected void penalty(Player p) {
        p.offsetQuality(-3);
        if (!p.getHand().isEmpty())
        {
            Card discard = p.chooseDiscard();
            setFailOutcome(p, "3 Quality Points and " + discard.getCardName() + ".");
        }
        setFailOutcome(p, "3 Quality Points");
    }

}