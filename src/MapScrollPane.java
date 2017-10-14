import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapScrollPane extends JScrollPane {
    public MapScrollPane() {
        //Read and store CSULBMap5_1200x1437.png as JLabel
        BufferedImage CSULBMapImage = null;

        try{
            CSULBMapImage = ImageIO.read(this.getClass().getResource("CSULBMap5_1200x1437.png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        if (CSULBMapImage != null) {
            ImageIcon CSULBMapIcon = new ImageIcon(CSULBMapImage);
            javax.swing.JLabel CSULBMapLabel = new javax.swing.JLabel(CSULBMapIcon);
            setViewportView(CSULBMapLabel);

        }

        super.setSize(1000, 1000);
        //Increase scroll speed
        super.getVerticalScrollBar().setUnitIncrement(20);

    }
}
