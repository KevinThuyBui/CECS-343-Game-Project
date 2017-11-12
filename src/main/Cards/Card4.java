package main.Cards;

import main.Player;

public class Card4 extends Card {

    public Card4(){
        cardName = "Professor Murgolo's CECS 174 Class";
        location = "ECS 302";
        reward = "1 Learning Chip";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().getName().equals(location)) {
            thisPlayer.offsetLearning( 1);                                  //get 1 learning Chip
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