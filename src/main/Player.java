package main;

import main.Cards.Card;

import java.awt.*;
import java.util.ArrayList;

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

    ArrayList<Card> getUserHand();

    void draw();

    void discardCard(Card display);
}
