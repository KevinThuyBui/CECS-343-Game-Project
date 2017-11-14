package main.cards;

import main.player.Player;
import main.Room;

public class Card18 extends Card {

    public Card18(){
        super("Choosing a Major", 3, 0, 0);
    }


    @Override
    public boolean canPlay(Room room) {
        return room == Room.CECS_CONFERENCE_ROOM;
    }

    @Override
    protected void success(Player p) {
        p.offsetQuality(5);
        setSuccessOutcome(p, "5 Quality Points.");
    }

    @Override
    protected void penalty(Player p) {
        p.offsetQuality(-3);
        setFailOutcome(p, "3 Quality Points.");
    }

}
