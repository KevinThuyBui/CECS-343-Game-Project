package main;

public class card0 extends Card {

    private static String cardName;
    private static String location0; //location where card is allowed to play
    private static String location1;
    private static String reward;
    private String outcome;


    public card0(){
        cardName = "CECS 105";
        location0 = "ECS 302";
        location1 = "ECS 308";
        reward = "1 Learning Chip";
    }

    @Override
    public String getCardName() {
        return cardName;
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().getName().equals(location0) | thisPlayer.getRoom().getName().equals(location1)) {
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
