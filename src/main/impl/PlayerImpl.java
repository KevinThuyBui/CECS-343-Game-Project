package main.impl;/*    Copyright 2017 Ton Ly
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

import main.cards.Card;
import main.cards.Decks;
import main.Player;
import main.Room;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player {

    private final String name;
    private final List<Card> hand;

    private Room currentRoom;

    private int integrety;
    private int craft;
    private int learning;
    private int quality;
    private boolean isUser;


    public PlayerImpl(String name, Room currentRoom, int integrety, int craft, int learning, int quality) {
        this.name = name;
        this.currentRoom = currentRoom;
        this.integrety = integrety;
        this.craft = craft;
        this.learning = learning;

        hand = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point getPoint() {
        return currentRoom.getDrawPosition();
    }

    @Override
    public int getIntegrity() {
        return integrety;
    }

    @Override
    public int getCraft() {
        return craft;
    }

    @Override
    public int getLearning() {
        return learning;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public void offsetLearning(int value) {
        learning += value;
    }

    @Override
    public void offsetCraft(int value) {
        craft += value;
    }

    @Override
    public void offsetIntegrity(int value) {
        integrety += value;
    }

    @Override
    public void offsetQuality(int value) {
        quality += value;
    }

    @Override
    public Room getRoom() {
        return currentRoom;
    }

    @Override
    public void setRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void discardCard(Card card) {
        if (hand.remove(card))
            Decks.getInstance().addToDiscard(card);
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void drawCard() {
        this.hand.add(0, Decks.getInstance().drawCard());
    }

    @Override
    public String chooseChip(boolean learning, boolean craft, boolean integrity) {
        return null;
    }
}

