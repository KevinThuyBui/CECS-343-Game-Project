package main.cards;

import main.Room;
import main.player.Player;

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
        Card discard = p.chooseDiscard();
        setFailOutcome(p, discard + ".");
    }
}
