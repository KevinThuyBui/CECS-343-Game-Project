package main;

public class card2 extends Card {
    private String cardName;
    private String location;
    private String reward;
    private String outcome;

    public card2(){
        cardName = "Lunch at Bratwurst Hall";
        location = "Bratwurst Hall";
        reward = "1 Craft Chip";
    }

    @Override
    public String getCardName() {
        return cardName;
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
