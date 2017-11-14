package main;

import main.player.Player;
import main.util.ScrollPaneMouseDragAdapter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;

class MapScrollPane extends JScrollPane {

    private final JLabel mapLabel;

    MapScrollPane() {
        //Read and store CSULBMap5_1200x1437.png as BufferedImage
        final BufferedImage mapImage = readMapFromFile();
        //If image is stored in BufferedImage create a JLabel to be stored in main.MapScrollPane View
        mapLabel = createJLabel(mapImage);
        JPanel container = new JPanel();
        container.add(mapLabel);
        setViewportView(container);


        setSize(1000, 1000);
        //Increase scroll speed
        getVerticalScrollBar().setUnitIncrement(20);

        //Enable mouse drag to scroll
        setAutoscrolls(true);
        MouseAdapter ma = new ScrollPaneMouseDragAdapter(mapLabel);
        mapLabel.addMouseListener(ma);
        mapLabel.addMouseMotionListener(ma);
    }


    private BufferedImage readMapFromFile() {
        final BufferedImage CSULBMapImage;
        try {
            CSULBMapImage = ImageIO.read(this.getClass().getResource("CSULBMap5_1200x1437.png"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load map image", e);
        }

        return CSULBMapImage;
    }

    private JLabel createJLabel(BufferedImage image) {
        return new JLabel(new ImageIcon(image));
    }


    public void initializePlayerTokens(PlayerController playerState) {
        Font playerFont = new Font("Setif", Font.BOLD, 20);

        Player[] players = playerState.getPlayers();

        JLabel[] jLabels = new JLabel[players.length];

        for (int i = 0; i < players.length; i++) {
            JLabel playerLabel = new JLabel();
            playerLabel.setText(players[i].getName());
            playerLabel.setFont(playerFont);
            playerLabel.setSize(100, 30);
            playerLabel.setForeground(Color.YELLOW);
            playerLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            playerLabel.setOpaque(true);
            playerLabel.setBackground(new Color(0, 0, 0, 150));
            playerLabel.setLocation(Room.ECS_308.getDrawPosition());
            mapLabel.add(playerLabel);
            jLabels[i] = playerLabel;
        }
        jLabels[0].setBorder(BorderFactory.createLineBorder(Color.GREEN.darker(), 1));
        jLabels[0].setBackground(new Color(0, 30, 0, 150));

        playerState.setPlayerLabels(jLabels);
    }


}
