import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;

public class MainView extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private MainView() {
		


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100,100, 1200, 1000);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Create a scrollPane for map
		ImageIcon CSULBMapIcon = null;

		//Create the image for the scrollPane
		BufferedImage CSULBMapImage = null;
		
		try{
			CSULBMapImage = ImageIO.read(new File ("resources/CSULBMap5_1200x1437.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}


		if (CSULBMapImage != null) {
			CSULBMapIcon = new ImageIcon(CSULBMapImage);
		}
		javax.swing.JLabel CSULBMapLabel = new javax.swing.JLabel(CSULBMapIcon);

		
		JScrollPane scrollPane = new JScrollPane(CSULBMapLabel);
		scrollPane.setSize(1000, 1000);
		getContentPane().add(scrollPane, BorderLayout.CENTER);	
	
		//Create a panel to hold the player information and interactions below
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
	}

}
