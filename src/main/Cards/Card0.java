package main.Cards;

import main.Player;

public class Card0 extends Card {

    public Card0(){
        cardName = "CECS 105";
        location = "CECS 302";
        location1 = "CECS 308";
        reward = "1 Learning Chip";
    }


    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().getName().equals(location) | thisPlayer.getRoom().getName().equals(location1)) {
            thisPlayer.offsetLearning( 1);                                  //get 1 learning Chip
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else
        {
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }

    @Override
    public String toString() {
        return outcome;
    }
}
