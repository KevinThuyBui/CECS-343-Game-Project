package main;

public class card3 extends Card {

    private String cardName;
    private String location;
    private String reward;
    private String outcome;

    public card3(){
        cardName = "Research Compilers";
        location = "Library";
        reward = "1 Learning Chip";
    }

    @Override
    public String getCardName() {
        return cardName;
    }

    @Override
    public void play(Player thisPlayer) {
        if (thisPlayer.getRoom().getName().equals(location)) {
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
