package main.Cards;

import java.util.ArrayList;
import java.util.Collections;

public class Decks {
    private static Decks ourInstance = new Decks();
    private static ArrayList<Card> drawingDeck;
    private static ArrayList<Card> discardDeck;

    public static Decks getInstance() {
        return ourInstance;
    }

    private Decks() {
    }

    public Card drawCard()
    {
        if (drawingDeck.isEmpty())
            reshuffleDeck();
        Card card = drawingDeck.get(0);
        drawingDeck.remove(0);
        return card;
    }

    public void addToDiscard (Card discardedCard)
    {
        discardDeck.add(discardedCard);
    }

    private void reshuffleDeck()
    {
        Collections.shuffle(discardDeck);
        drawingDeck = discardDeck;
        discardDeck = new ArrayList<>();
    }
}
