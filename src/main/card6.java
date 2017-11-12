package main;

public class card6 extends Card {

    private String cardName;
    private String location;
    private String reward;
    private String outcome;

    public card6(){
        cardName = "Exercising Mind and Body";
        location = "Student Recreation";
        reward = "1 Integrity Chip";
    }

    @Override
    public String getCardName() {
        return cardName;
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
