package main.player;

import main.Room;
import main.cards.Card;

import java.awt.*;
import java.util.List;

public interface Player {
    String getName();

    //set player to room attributes
    Point getPoint();

    int getIntegrity();

    int getCraft();

    int getLearning();

    int getQuality();

    void offsetLearning(int value);

    void offsetCraft(int value);

    void offsetIntegrity(int value);

    void offsetQuality(int value);

    Room getRoom();

    void setRoom(Room currentRoom);

    List<Card> getHand();

    void drawCard();

    void discardCard(Card display);

    Card chooseDiscard();

    default String chooseChip() {
        return chooseChip(true, true, true);
    }

    String chooseChip(boolean learning, boolean craft, boolean integrity);
}
