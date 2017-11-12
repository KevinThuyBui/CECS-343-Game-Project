package main.Cards;

import main.Player;

public abstract class Card {
    String cardName;
    String location; //location where card is allowed to play
    String location1;
    String reward;
    String outcome;
    String filePath;

    public String getCardName()
    {
        return cardName;
    }

    public String getFilePath()
    {
        return filePath;
    }

    abstract void play(Player thisPlayer);
}