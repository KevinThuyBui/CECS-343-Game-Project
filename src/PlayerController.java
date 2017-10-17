import javax.swing.*;

public class PlayerController {
    private static Player player1;
    private static Player player2;
    private static Player player3;
    //Player tokens initialized in MapScrollPane
    private static JLabel playerToken1, playerToken2, playerToken3;

    PlayerController()
    {
        player1 = new Player();
        player2 = new Player();
        player3 = new Player();
    }
    //This function to be called by the Control Panel's move button
    public void updatePlayerPositions()
    {
        playerToken1.setLocation(player1.getPoint());
        playerToken2.setLocation(player2.getPoint());
        playerToken3.setLocation(player3.getPoint());
    }
    //Gets pointers to the player tokens
    public void setPlayerTokens(JLabel playerToken1, JLabel playerToken2, JLabel playerToken3)
    {
        PlayerController.playerToken1 = playerToken1;
        PlayerController.playerToken2 = playerToken2;
        PlayerController.playerToken3 = playerToken3;
    }
}
