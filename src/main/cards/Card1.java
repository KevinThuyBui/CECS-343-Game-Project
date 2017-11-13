
package main.cards;

import main.Player;
import main.Room;
import main.ChipDialog;

public class Card1 extends Card {

    String oneUp;

    public Card1(){
        this.cardName = "Math 122";
        this.location = "Library";
        this.reward = "1 Learning or 1 Integrity chip";
        this.imagePath = "main/Cards/cardm01.png";
    }

    @Override
    public void play(Player thisPlayer)
    {
        if(thisPlayer.getRoom() == Room.LIBRARY){       //played in the Library
            //if(thisPlayer.isUser()) {                        //ask player if this player is the user
               ChipDialog chip = new ChipDialog();
               oneUp = chip.showDialog(true, false, true); // open a dialog ask player to choose a learning chip or integrity chip with an action listener
                processChipDialog( thisPlayer, oneUp);
            //}
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else{
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
