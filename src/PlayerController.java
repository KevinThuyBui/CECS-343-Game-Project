import javax.swing.*;
import java.awt.*;
import java.util.Random;

class PlayerController {
    private static Player player1;
    private static Player player2;
    private static Player player3;
    //Player tokens initialized in MapScrollPane
    private static JLabel playerToken1, playerToken2, playerToken3;
    //Offset required to prevent collision of tokens
    private static final int PLAYER2OFFSET = 30;
    private static final int PLAYER3OFFSET = 60;

    PlayerController()
    {
        player1 = new Player(Room.ECS_302, 0, 0, 0, 0);
        player2 = new Player(Room.ECS_302, 0, 0, 0, 0);
        player3 = new Player(Room.ECS_302, 0, 0, 0, 0);
    }
    //This function to be called by the Control Panel's move buttonh
    void updatePlayerPositions()
    {
        playerToken1.setLocation(player1.getPoint());
        playerToken2.setLocation(addOffset(player2.getPoint(), PLAYER2OFFSET));
        playerToken3.setLocation(addOffset(player3.getPoint(), PLAYER3OFFSET));
    }
    //Gets pointers to the player tokens
    void setPlayerTokens(JLabel playerToken1, JLabel playerToken2, JLabel playerToken3)
    {
        PlayerController.playerToken1 = playerToken1;
        PlayerController.playerToken2 = playerToken2;
        PlayerController.playerToken3 = playerToken3;
    }

    private Point addOffset(Point playerPoint, int offSet)
    {
        return new Point(playerPoint.x , playerPoint.y +offSet);

    }

    //added randomly selects a position for player2 and player3
    public void setARandomRoom(Player player)
    {
        Random randomRooms = new Random();
        int aRandomRoom = randomRooms.nextInt(player.getNumOfAdjecentRooms()+1);
        player.setToAnAjacentRoom(aRandomRoom);
    }
}
