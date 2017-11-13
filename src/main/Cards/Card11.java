package main.Cards;

import main.ChipDialog;
import main.Player;
import main.Room;

public class Card11 extends Card {

    String oneUp;

    public Card11(){
        this.cardName = "Buddy Up";
        this.location = "EAT Room or George Allen Field";
        this.reward = "1 Learning or 1 Craft chip";
        this.filePath = "main/Cards/cardm11.png";
    }

    @Override
    public void play(Player thisPlayer)
    {
        if(thisPlayer.getRoom() == Room.EAT_CLUB || thisPlayer.getRoom() == Room.GEORGE_ALLEN_FIELD){       //played in the Library
            //if(thisPlayer.isUser()) {                        //ask player if this player is the user
                ChipDialog chip = new ChipDialog();
                oneUp = chip.showDialog(true, true, false); // open a dialog ask player to choose a learning chip or integrity chip with an action listener
                processChipDialog( thisPlayer, oneUp);
            //}
            outcome = successfulOutcomeString(thisPlayer.getName());
        }
        else{
            outcome = failedOutcomeString(thisPlayer.getName());
        }
    }
}
