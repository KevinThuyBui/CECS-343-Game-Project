package main.Cards;

import main.Player;

public class Card2 extends Card {


    public Card2(){
        cardName = "Lunch at Bratwurst Hall";
        location = "Bratwurst Hall";
        reward = "1 Craft Chip";
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().getName().equals(location)) {           //played at Bratwurst Hall
            thisPlayer.offsetCraft(1);     //get 1 Craft Chip
            outcome = thisPlayer.getName() + " was awarded " + reward;
        }
        else{
            outcome = thisPlayer.getName() + " was unabled to play: " + cardName;
        }
    }

    @Override
    public String toString() {
        return outcome;
    }
}
