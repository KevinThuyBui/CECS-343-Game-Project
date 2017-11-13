package main.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Decks {
    private static Decks ourInstance = new Decks();
    private ArrayList<Card> drawingDeck;
    private ArrayList<Card> discardDeck;

    public static Decks getInstance() {
        return ourInstance;
    }

    private Decks() {
        drawingDeck = new ArrayList<>();
        discardDeck = new ArrayList<>();
        initalizeDrawingDeck();
    }

    private void initalizeDrawingDeck() {
        drawingDeck.add(new Card39());
        drawingDeck.add(new Card38());
        drawingDeck.add(new Card37());
        drawingDeck.add(new Card36());
        drawingDeck.add(new Card35());
        drawingDeck.add(new Card34());
        drawingDeck.add(new Card33());
        drawingDeck.add(new Card32());
        drawingDeck.add(new Card31());
        drawingDeck.add(new Card30());

        drawingDeck.add(new Card29());
        drawingDeck.add(new Card28());
        drawingDeck.add(new Card27());
        drawingDeck.add(new Card26());
        drawingDeck.add(new Card25());
        drawingDeck.add(new Card24());
        drawingDeck.add(new Card23());
        drawingDeck.add(new Card22());
        drawingDeck.add(new Card21());
        drawingDeck.add(new Card20());

        drawingDeck.add(new Card19());
        drawingDeck.add(new Card18());
        drawingDeck.add(new Card17());
        drawingDeck.add(new Card16());
        drawingDeck.add(new Card15());
        drawingDeck.add(new Card14());
        drawingDeck.add(new Card13());
        drawingDeck.add(new Card12());
        drawingDeck.add(new Card11());
        drawingDeck.add(new Card10());

        drawingDeck.add(new Card9());
        drawingDeck.add(new Card8());
        drawingDeck.add(new Card7());
        drawingDeck.add(new Card6());
        drawingDeck.add(new Card5());
        drawingDeck.add(new Card4());
        drawingDeck.add(new Card3());
        drawingDeck.add(new Card2());
        drawingDeck.add(new Card1());

        Collections.shuffle(drawingDeck);
    }

    public Card drawCard() {
        if (drawingDeck.isEmpty())
            reshuffleDeck();
        return drawingDeck.remove(0);
    }

    public void addToDiscard(Card discardedCard) {
        discardDeck.add(discardedCard);
    }

    private void reshuffleDeck() {
        Collections.shuffle(discardDeck);
        drawingDeck = discardDeck;
        discardDeck = new ArrayList<>();
    }

    public int drawCount() {
        return drawingDeck.size();
    }

    public int discardCount() {
        return discardDeck.size();
    }
}
