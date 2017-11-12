package main.Cards;

import main.Player;

public class Card3 extends Card {

    public Card3(){
        cardName = "Research Compilers";
        location = "Library";
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
