import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
		//Create the Jpanel for the entire application
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100,100, 1244, 1000);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//Create a PlayerController to store player positions
		PlayerController playerState = new PlayerController();

		//Create a MapScrollPane for game map
		MapScrollPane scrollPane = new MapScrollPane(playerState);
		getContentPane().add(scrollPane, BorderLayout.CENTER);	
	
		//Create a panel to hold the player information and interactions below
		final ControlPanel controlPanel = new ControlPanel();
		getContentPane().add(controlPanel, BorderLayout.SOUTH);
	}

}
