package main.Cards;

import main.Player;

public class Card5 extends Card {

    public Card5(){
        cardName = "CECS 100";
        location = "ECS 308";
        reward = "1 Craft Token";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().getName().equals(location)) {
            thisPlayer.offsetCraft( 1);                                  //get 1 craft token
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
