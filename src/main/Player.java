package main;

import main.cards.Card;

import java.awt.*;
import java.util.List;

public interface Player {
    String getName();

    //set player to room attributes
    Point getPoint();

    int getIntegrety();

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

    void draw();

    void discardCard(Card display);
}
