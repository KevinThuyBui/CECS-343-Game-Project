package main;

public class card5 extends Card {

    private String cardName;
    private String location;
    private String reward;
    private String outcome;

    public card5(){
        cardName = "CECS 100";
        location = "ECS 308";
        reward = "1 Craft Token";
    }

    @Override
    public String getCardName() {
        return cardName;
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
