import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class MapScrollPane extends JScrollPane {
    public static JLabel playerToken1, playerToken2, playerToken3;
    public static final int PLAYER2OFFSET = 30;
    public static final int PLAYER3OFFSET = 60;

    MapScrollPane() {
        //Read and store CSULBMap5_1200x1437.png as BufferedImage
        BufferedImage CSULBMapImage = readMapFromFile();
        //If image is stored in BufferedImage create a JLabel to be stored in MapScrollPane View
        if (CSULBMapImage != null) {
            JLabel CSULBMapLabel = createJLabel(CSULBMapImage);

            initializePlayerTokens();
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

    private void initializePlayerTokens()
    {
        Font playerFont = new Font("Setif", Font.BOLD, 20);

        playerToken1 = new JLabel();
        playerToken1.setLocation(Rooms.ECS_308.xDrawPosition, Rooms.ECS_308.yDrawPosition);
        playerToken2 = new JLabel();
        playerToken2.setLocation(Rooms.ECS_308.xDrawPosition, Rooms.ECS_308.yDrawPosition + PLAYER2OFFSET);
        playerToken3 = new JLabel();
        playerToken3.setLocation(Rooms.ECS_308.xDrawPosition, Rooms.ECS_308.yDrawPosition + PLAYER3OFFSET);

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
