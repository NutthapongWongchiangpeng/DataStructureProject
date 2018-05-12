package AmusementPark;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GamePlay {

	public static JFrame frame;
	GameFrame gf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePlay window = new GamePlay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GamePlay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 806, 629);
		frame.setTitle("Amusement Park");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gf = new GameFrame();
		frame.getContentPane().add(gf);
		
	}
}
