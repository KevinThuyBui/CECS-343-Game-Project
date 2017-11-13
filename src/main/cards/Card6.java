package main.cards;

import main.Player;

public class Card6 extends Card {

    static String oneUp = "integrity";

    public Card6(){
        cardName = "Exercising Mind and Body";
        location = "Student Recreation";
        reward = "1 Integrity Chip";
        imagePath = "main/Cards/cardm06.png";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().getName().equals(location)) {
            processChipDialog( thisPlayer, oneUp);                                  //get 1 Integrity chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
