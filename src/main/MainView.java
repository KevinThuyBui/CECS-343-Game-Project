package main;

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    private final ControlPanel controlPanel;
    private final PlayerController playerState;

    /**
     * Create the frame.
     */
    private MainView() {
        //Create the Jpanel for the entire application
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1244, 1000);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        //Create a PlayerController to store player positions
        playerState = new PlayerController();
        //Create a MapScrollPane for game map
        MapScrollPane map = new MapScrollPane();
        map.initializePlayerTokens(playerState);

        //Create a panel to hold the player information and interactions below
        controlPanel = new ControlPanel(playerState);
        playerState.setControlPanel(controlPanel);

        getContentPane().add(map, BorderLayout.CENTER);

        getContentPane().add(controlPanel, BorderLayout.SOUTH);
        setVisible(true);
        playerState.nextTurn();
    }

}
