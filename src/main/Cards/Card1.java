//requires dialog
package main.Cards;

import main.Player;

public class Card1 extends Card {

    public Card1(){
        cardName = "Math 122";
        location = "Library";
    }

    @Override
    public void play(Player thisPlayer)
    {
        if(thisPlayer.getRoom().getName().equals(location)){       //played in the Library
            if(thisPlayer.isUser()) {                        //ask player if this player is the user
                                                                //open a dialog ask player to choose a learning chip or integrity chip with an action listener
                                                                //updates reward
            }
            outcome = thisPlayer.getName() + " was awarded " + reward;
        }
        else{
            outcome = thisPlayer.getName() + " was unable to Play " + cardName;
        }
    }

    @Override
    public String toString() {
        return outcome;
    }
}
