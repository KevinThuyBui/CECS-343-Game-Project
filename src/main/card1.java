//requires dialog
package main;

public class card1 extends Card {

    private static String cardName = "Math122";
    private static String location = "Library";
    private String reward; // "1 Learning Chip or 1 Integrity Chip"
    private String outcome;

    @Override
    public String getCardName() {
        return cardName;
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
