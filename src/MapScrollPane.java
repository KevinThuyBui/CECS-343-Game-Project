import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class MapScrollPane extends JScrollPane {
    MapScrollPane() {
        //Read and store CSULBMap5_1200x1437.png as BufferedImage
        BufferedImage CSULBMapImage = readMapFromFile();
        //If image is stored in BufferedImage create a JLabel to be stored in MapScrollPane View
        if (CSULBMapImage != null) {
            JLabel CSULBMapLabel = createJLabel(CSULBMapImage);
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

}
