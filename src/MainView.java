import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;

public class MainView extends JFrame {

	private JPanel contentPane;

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
	public MainView() {
		


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, 1200, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Create a scrollPane for map
		ImageIcon CSULBMapIcon = null;

		//Create the image for the scrollPane
		BufferedImage CSULBMapImage = null;
		
		try{
			CSULBMapImage = ImageIO.read(new File ("c:\\Users\\Milksauce\\CECS-343-Game-Project\\resources\\CSULBMap5_1200x1437.png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}


		CSULBMapIcon = new ImageIcon(CSULBMapImage);
		javax.swing.JLabel CSULBMapLabel = new javax.swing.JLabel(CSULBMapIcon);

		
		JScrollPane scrollPane = new JScrollPane(CSULBMapLabel);
		scrollPane.setSize(1000, 1000);
		getContentPane().add(scrollPane, BorderLayout.CENTER);	
	
		//Create a panel to hold the player information and interactions below
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
	}

}
