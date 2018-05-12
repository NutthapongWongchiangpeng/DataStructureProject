package AmusementPark;

import java.awt.EventQueue;

import javax.print.attribute.standard.Media;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

import java.awt.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javafx.*;

public class RunGUI {

	public static JFrame frmAmusement;
	public JLabel lblBgOp;
	public JLabel lblStart;
	public JLabel lblHowTo;
	public JLabel lblHowToBg;
	public JLabel lblExit;
	public static JLabel SoundICON;
	public JLabel BackICON;
	public JLabel SelectStart;
	public JLabel SelectHowTo;
	public JLabel SelectExit;
	public JLabel txtStart;
	public JLabel txtHowTo;
	public JLabel txtExit;
	public GamePlay gp;
	GameFrame gf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunGUI window = new RunGUI();
					window.frmAmusement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RunGUI() throws IOException {
		PlaySound.sound.loop();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frmAmusement = new JFrame();
		frmAmusement.setTitle("Amusement Park");
		frmAmusement.setResizable(false);
		frmAmusement.setBounds(50, 50, 806, 629);
		frmAmusement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmusement.getContentPane().setLayout(new BorderLayout(0, 0));

		// create Volume Icon //
		SoundICON = new JLabel("");
		SoundICON.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (SoundICON.getIcon().toString() == "Image/etc/volume.png") {
					SoundICON
							.setIcon(new ImageIcon("Image/etc/volume mute.png"));
					PlaySound.sound.stop();
				} else {
					SoundICON.setIcon(new ImageIcon("Image/etc/volume.png"));
					PlaySound.sound.loop();
				}
			}
		});
		SoundICON.setIcon(new ImageIcon("Image/etc/volume.png"));
		SoundICON.setBounds(0, 0, 40, 40);
		SoundICON.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frmAmusement.getContentPane().add(SoundICON);

		// create SelectStart //
		SelectStart = new JLabel("");
		SelectStart.setIcon(new ImageIcon("Image/etc/select1.png"));
		SelectStart.setBounds(320, 362, 13, 20);
		frmAmusement.getContentPane().add(SelectStart);
		SelectStart.setVisible(false);

		// create SelectHowTo //
		SelectHowTo = new JLabel("");
		SelectHowTo.setIcon(new ImageIcon("Image/etc/select1.png"));
		SelectHowTo.setBounds(260, 433, 13, 20);
		frmAmusement.getContentPane().add(SelectHowTo);
		SelectHowTo.setVisible(false);

		// create SelectExit //
		SelectExit = new JLabel("");
		SelectExit.setIcon(new ImageIcon("Image/etc/select1.png"));
		SelectExit.setBounds(335, 502, 13, 20);
		frmAmusement.getContentPane().add(SelectExit);
		SelectExit.setVisible(false);

		// create BackICON //
		BackICON = new JLabel("");
		BackICON.setIcon(new ImageIcon("Image/etc/back.png"));
		BackICON.setBounds(17, 504, 90, 90);
		BackICON.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// create lblStart //
		lblStart = new JLabel("");
		lblStart.setIcon(new ImageIcon("Image/etc/button.png"));
		lblStart.setBounds(265, 340, 255, 65);
		frmAmusement.getContentPane().add(lblStart);
		lblStart.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// create lblHowTo //
		lblHowTo = new JLabel("");
		lblHowTo.setIcon(new ImageIcon("Image/etc/button.png"));
		lblHowTo.setBounds(265, 410, 255, 65);
		frmAmusement.getContentPane().add(lblHowTo);
		lblHowTo.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// create lblExit //
		lblExit = new JLabel("");
		lblExit.setIcon(new ImageIcon("Image/etc/button.png"));
		lblExit.setBounds(265, 480, 255, 65);
		frmAmusement.getContentPane().add(lblExit);
		lblExit.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// create txtStart //
		txtStart = new JLabel("Start");
		txtStart.setForeground(Color.WHITE);
		txtStart.setFont(new Font("Dialog", Font.BOLD, 35));
		txtStart.setBounds(350, 320, 300, 100);
		frmAmusement.getContentPane().add(txtStart);

		// create txtStart //
		txtHowTo = new JLabel("How To Play");
		txtHowTo.setForeground(Color.WHITE);
		txtHowTo.setFont(new Font("Dialog", Font.BOLD, 35));
		txtHowTo.setBounds(290, 390, 300, 100);
		frmAmusement.getContentPane().add(txtHowTo);

		// create txtExit //
		txtExit = new JLabel("Exit");
		txtExit.setForeground(Color.WHITE);
		txtExit.setFont(new Font("Dialog", Font.BOLD, 35));
		txtExit.setBounds(362, 460, 300, 100);
		frmAmusement.getContentPane().add(txtExit);

		// create lblBgOp //
		lblBgOp = new JLabel("");
		lblBgOp.setIcon(new ImageIcon("Image/Page/home1.png"));
		lblBgOp.setBounds(0, 0, 800, 600);
		frmAmusement.getContentPane().add(lblBgOp);

		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmAmusement.setVisible(false);
				gp = new GamePlay();
				PlaySound.sound1.play();
				gp.frame.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SelectStart.setVisible(true);
			}

			public void mouseExited(MouseEvent e) {
				SelectStart.setVisible(false);
			}
		});

		lblHowTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PlaySound.sound1.play();
				lblBgOp.setVisible(false);
				lblStart.setVisible(false);
				lblHowTo.setVisible(false);
				lblExit.setVisible(false);
				txtStart.setVisible(false);
				txtHowTo.setVisible(false);
				txtExit.setVisible(false);
				SelectStart.setVisible(false);
				SelectHowTo.setVisible(false);
				SelectExit.setVisible(false);
				frmAmusement.getContentPane().add(BackICON);
				
				// How to BackGround//
				lblHowToBg = new JLabel("");
				lblHowToBg.setIcon(new ImageIcon("Image/Page/howto.jpg"));
				lblHowToBg.setBounds(0, 0, 800, 600);
				frmAmusement.getContentPane().add(lblHowToBg);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SelectHowTo.setVisible(true);
			}

			public void mouseExited(MouseEvent e) {
				SelectHowTo.setVisible(false);
			}
		});

		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PlaySound.sound2.play();
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				SelectExit.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				SelectExit.setVisible(false);
			}
		});

		BackICON.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PlaySound.sound2.play();
				lblHowToBg.setVisible(false);
				lblBgOp.setVisible(true);
				lblStart.setVisible(true);
				lblHowTo.setVisible(true);
				lblExit.setVisible(true);
				lblBgOp.setVisible(true);
				txtStart.setVisible(true);
				txtHowTo.setVisible(true);
				txtExit.setVisible(true);
			}
		});
	}
}
