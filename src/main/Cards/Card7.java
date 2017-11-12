package main.Cards;

import main.Player;

public class Card7 extends Card {

    public Card7(){
        cardName = "Finding the Lab";
        location = "Elevators";
        reward = "1 Integrity Chip";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().getName().equals(location)) {
            thisPlayer.offsetIntegrity( 1);                                  //get 1 Integrity chip
            outcome = thisPlayer.getName() + " was awarded " + reward;
        }
        else
        {
            outcome = thisPlayer.getName() + " was unabled to play: " + cardName;
        }
    }

    @Override
    public String toString() {
        return outcome;
    }
}
