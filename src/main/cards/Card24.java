package main.cards;

import main.CardDialog;
import main.Player;
import main.Room;

public class Card24 extends Card {

    Card24() {
        super("Meet the Dean", 3, 3, 3);
    }

    @Override
    public boolean canPlay(Room room) {
        return room == Room.ECS_302 || room == Room.ECS_308;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(3);
        p.drawCard();
        setSuccessOutcome(p, "5 Quality Points and a card.");
    }

    @Override
    protected void penalty(Player p) {
        Card discard = new CardDialog().display(p);
        p.discardCard(discard);
        setFailOutcome(p, discard + ".");
    }
}
