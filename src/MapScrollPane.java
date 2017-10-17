import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class MapScrollPane extends JScrollPane {
    private static JLabel playerToken1, playerToken2, playerToken3;


    MapScrollPane(PlayerController playerState) {
        //Read and store CSULBMap5_1200x1437.png as BufferedImage
        BufferedImage CSULBMapImage = readMapFromFile();
        //If image is stored in BufferedImage create a JLabel to be stored in MapScrollPane View
        if (CSULBMapImage != null) {
            JLabel CSULBMapLabel = createJLabel(CSULBMapImage);

            initializePlayerTokens(playerState);
            CSULBMapLabel.add(playerToken1);
            CSULBMapLabel.add(playerToken2);
            CSULBMapLabel.add(playerToken3);


            setViewportView(CSULBMapLabel);
        }

        super.setSize(1000, 1000);
        //Increase scroll speed
        super.getVerticalScrollBar().setUnitIncrement(20);

    }


    private BufferedImage readMapFromFile()
    {
        BufferedImage CSULBMapImage = null;

        try{
            CSULBMapImage = ImageIO.read(this.getClass().getResource("CSULBMap5_1200x1437.png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return CSULBMapImage;
    }

    private JLabel createJLabel(BufferedImage image)
    {
        return new JLabel( new ImageIcon(image));
    }

    private void initializePlayerTokens(PlayerController playerState)
    {
        Font playerFont = new Font("Setif", Font.BOLD, 20);

        playerToken1 = new JLabel();
        playerToken2 = new JLabel();
        playerToken3 = new JLabel();

        playerState.setPlayerTokens(playerToken1, playerToken2, playerToken3);
        playerState.updatePlayerPositions();

        playerToken1.setText("Player1");
        playerToken2.setText("Player2");
        playerToken3.setText("Player3");

        playerToken1.setSize(100, 30);
        playerToken2.setSize(100,30);
        playerToken3.setSize(100, 30);

        playerToken1.setFont(playerFont);
        playerToken2.setFont(playerFont);
        playerToken3.setFont(playerFont);

        playerToken1.setForeground(Color.red);
        playerToken2.setForeground(Color.red);
        playerToken3.setForeground(Color.red);
    }



}
