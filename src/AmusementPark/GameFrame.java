package AmusementPark;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener {

	public static GameFrame mainInstance;
	static Timer mainTimer;
	boolean cEnd = true;
	public static Calendar cal = Calendar.getInstance();
	public static Calendar calend = Calendar.getInstance();
	Player player;
	Bot01 bot01;
	Bot02 bot02;
	Bot03 bot03;
	LinkedQueue queue = new LinkedQueue();
	StringBuilder word = new StringBuilder();
	int cCheck[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	// Building//
	public ObjCreator snowtown, cave, wheel, haunted, theater, circus, EnterLapas, EnterTrain, Exit;
	// Block Wall//
	BlockCreator Block00, Block0200, Block0301, Block0575, Block1910, Block19175, Block3540, Block4770, Block35255,
			Block61645, Block63287, Block240450, Block269347, Block293551, Block411160, Block473287, Block473301,
			Block543347, Block648100, Block684120, Block764146;

	Thread tr = new Thread();
	public Graphics2D g2d;
	JLabel lblB;
	static int tm = 0;
	int f = 0, m = 0, j = 0;
	int temp_score_f = 0, temp_score_m = 0;
	int totalCost = 0;
	String textFun = "Normal";

	// create label//
	JLabel lblBg;
	JLabel lblBlack = new JLabel();
	JLabel lblEnterCave = new JLabel();
	JLabel lblEnterCircus = new JLabel();
	JLabel lblEnterHaunted = new JLabel();
	JLabel lblEnterSnow = new JLabel();
	JLabel lblEnterTheater = new JLabel();
	JLabel lblEnterWheel = new JLabel();
	JLabel lblSnowTown = new JLabel();
	JLabel lblCave = new JLabel();
	JLabel lblWheel = new JLabel();
	JLabel lblHaunted = new JLabel();
	JLabel lblTheater = new JLabel();
	JLabel lblCircus = new JLabel();
	JLabel lblYes = new JLabel();
	JLabel lblNo = new JLabel();
	JLabel lblExitYes = new JLabel();
	JLabel lblExitNo = new JLabel();
	JLabel lblArrowExit = new JLabel();
	JLabel SelectYes = new JLabel();
	JLabel SelectNo = new JLabel();

	JLabel time = new JLabel();
	JLabel fun = new JLabel();
	JLabel money = new JLabel();
	JLabel txtTime = new JLabel();
	JLabel txtFun = new JLabel();
	JLabel txtMoney = new JLabel();
	JLabel txtMessageUp = new JLabel();
	JLabel txtMessageDown = new JLabel();
	JLabel txtYes = new JLabel();
	JLabel txtNo = new JLabel();

	static Timer timer;
	String stime;
	Date date;
	SimpleDateFormat sf;

	public GameFrame() {
		// create DateTime //
		mainInstance = this;
		cal.set(Calendar.HOUR_OF_DAY, 9);
		cal.set(Calendar.MINUTE, 0);
		calend.set(Calendar.HOUR_OF_DAY, 16);
		calend.set(Calendar.MINUTE, 00);
		
		// Volume Icon //
		JLabel SoundICON = new JLabel("");
		if (RunGUI.SoundICON.getIcon().toString() == "Image/etc/volume.png") {
			SoundICON.setIcon(new ImageIcon("Image/etc/volume.png"));
		}
		else if (RunGUI.SoundICON.getIcon().toString() == "Image/etc/volume mute.png") {
			SoundICON.setIcon(new ImageIcon("Image/etc/volume mute.png"));
		} 
		
		SoundICON.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (SoundICON.getIcon().toString() == "Image/etc/volume.png") {
					SoundICON.setIcon(new ImageIcon("Image/etc/volume mute.png"));
					PlaySound.sound.stop();
				} else if(SoundICON.getIcon().toString() == "Image/etc/volume mute.png"){
					SoundICON.setIcon(new ImageIcon("Image/etc/volume.png"));
					PlaySound.sound.loop();
				}
			}
		});
		SoundICON.setBounds(0, 0, 40, 40);
		add(SoundICON);

		// set start timer//
		GameFrame.tm = 0;

		// create "Emotion" text//
		txtFun.setText("Emotion : ");
		txtFun.setForeground(Color.BLACK);
		txtFun.setFont(new Font("Dialog", Font.BOLD, 22));
		txtFun.setBounds(577, 362, 300, 50);

		// create Emotion value//
		fun.setText("" + textFun);
		fun.setForeground(Color.BLACK);
		fun.setFont(new Font("Dialog", Font.BOLD, 22));
		fun.setBounds(684, 362, 300, 50);

		// create "time" text//
		txtTime.setText("Time : ");
		txtTime.setForeground(Color.BLACK);
		txtTime.setFont(new Font("Dialog", Font.BOLD, 22));
		txtTime.setBounds(577, 392, 300, 50);

		// create timer value//
		time.setText("");
		time.setForeground(Color.BLACK);
		time.setFont(new Font("Dialog", Font.BOLD, 22));
		time.setBounds(649, 392, 300, 50);

		// create "money" text//
		txtMoney.setText("Money : ");
		txtMoney.setForeground(Color.BLACK);
		txtMoney.setFont(new Font("Dialog", Font.BOLD, 22));
		txtMoney.setBounds(577, 422, 300, 50);

		// create "money" value//
		money.setText("1000");
		money.setForeground(Color.BLACK);
		money.setFont(new Font("Dialog", Font.BOLD, 22));
		money.setBounds(664, 422, 300, 50);

		// create "MessageUp" text//
		txtMessageUp.setText("");
		txtMessageUp.setForeground(Color.BLACK);
		txtMessageUp.setFont(new Font("Dialog", Font.BOLD, 20));
		txtMessageUp.setBounds(577, 472, 300, 50);

		// create "MessageDown" text//
		txtMessageDown.setText("");
		txtMessageDown.setForeground(Color.BLACK);
		txtMessageDown.setFont(new Font("Dialog", Font.BOLD, 20));
		txtMessageDown.setBounds(577, 495, 300, 50);
				
		// create lblYes//
		lblYes = new JLabel("");
		lblYes.setForeground(Color.BLACK);
		lblYes.setFont(new Font("Dialog", Font.BOLD, 20));
		lblYes.setIcon(new ImageIcon("Image/Message/YNMessage2.png"));
		lblYes.setBounds(558, 544, 120, 57);
		lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		// create SelectYes//
		SelectYes = new JLabel("");
		SelectYes.setIcon(new ImageIcon("Image/etc/select.png"));
		SelectYes.setBounds(576, 562, 13, 20);
		SelectYes.setVisible(false);
				
		// create SelectNo//
		SelectNo = new JLabel("");
		SelectNo.setIcon(new ImageIcon("Image/etc/select.png"));
		SelectNo.setBounds(696, 562, 13, 20);
		SelectNo.setVisible(false);

		// create lblNo//
		lblNo = new JLabel("");
		lblNo.setForeground(Color.BLACK);
		lblNo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNo.setIcon(new ImageIcon("Image/Message/YNMessage2.png"));
		lblNo.setBounds(678, 544, 120, 57);
		lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// create lblExitYes//
		lblExitYes = new JLabel("");
		lblExitYes.setForeground(Color.BLACK);
		lblExitYes.setFont(new Font("Dialog", Font.BOLD, 20));
		lblExitYes.setIcon(new ImageIcon("Image/Message/YNMessage2.png"));
		lblExitYes.setBounds(558, 544, 120, 57);

		// create lblExitNo//
		lblExitNo = new JLabel("");
		lblExitNo.setForeground(Color.BLACK);
		lblExitNo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblExitNo.setIcon(new ImageIcon("Image/Message/YNMessage2.png"));
		lblExitNo.setBounds(678, 544, 120, 57);
				
		// create Arrow Exit//
		lblArrowExit = new JLabel("");
		lblArrowExit.setIcon(new ImageIcon("Image/etc/ExitArrow.png"));
		lblArrowExit.setBounds(407, 561, 45, 45);
		lblArrowExit.setVisible(false);
				
		// create txtYesNo//
		txtYes = new JLabel("");
		txtYes.setForeground(Color.BLACK);
		txtYes.setFont(new Font("Dialog", Font.BOLD, 20));
		txtYes.setBounds(600, 560, 120, 20);
		txtNo = new JLabel("");
		txtNo.setForeground(Color.BLACK);
		txtNo.setFont(new Font("Dialog", Font.BOLD, 20));
		txtNo.setBounds(724, 560, 120, 20);
				
		// create EnterCave//
		lblEnterCave = new JLabel("");
		lblEnterCave.setIcon(new ImageIcon("Image/Building/EnterCave.png"));
		lblEnterCave.setBounds(431, 43, 48, 16);
		lblEnterCave.setVisible(false);

		// create EnterCircus//
		lblEnterCircus = new JLabel("");
		lblEnterCircus.setIcon(new ImageIcon("Image/Building/Entercircus.png"));
		lblEnterCircus.setBounds(133, 555, 28, 16);
		lblEnterCircus.setVisible(true);

		// create EnterHaunted//
		lblEnterHaunted = new JLabel("");
		lblEnterHaunted.setIcon(new ImageIcon("Image/Building/EnterHaunted.png"));
		lblEnterHaunted.setBounds(723, 124, 41, 19);
		lblEnterHaunted.setVisible(true);

		// create EnterSnow//
		lblEnterSnow = new JLabel("");
		lblEnterSnow.setIcon(new ImageIcon("Image/Building/EnterHaunted.png"));
		lblEnterSnow.setBounds(569, 199, 48, 16);
		lblEnterSnow.setVisible(true);

		// create EnterTheater//
		lblEnterTheater = new JLabel("");
		lblEnterTheater.setIcon(new ImageIcon("Image/Building/EnterTheater.png"));
		lblEnterTheater.setBounds(184, 456, 48, 16);
		lblEnterTheater.setVisible(true);

		// create EnterWheel//
		lblEnterWheel = new JLabel("");
		lblEnterWheel.setIcon(new ImageIcon("Image/Building/EnterWheel.png"));
		lblEnterWheel.setBounds(260, 164, 48, 16);
		lblEnterWheel.setVisible(true);

		// create lblBlack//
		lblBlack = new JLabel("");
		lblBlack.setIcon(new ImageIcon("Image/Page/black.png"));
		lblBlack.setBounds(0, 0, 800, 600);
		lblBlack.setVisible(false);

		// create lblSnowTown//
		lblSnowTown = new JLabel("");
		lblSnowTown.setIcon(new ImageIcon("Image/Building/Snow_Town.png"));
		lblSnowTown.setBounds(534, 93, 113, 107);
		lblSnowTown.setVisible(true);

		// create lblCave//
		lblCave = new JLabel("");
		lblCave.setIcon(new ImageIcon("Image/Building/Cave.png"));
		lblCave.setBounds(432, 1, 46, 48);
		lblCave.setVisible(true);

		// create lblWheel//
		lblWheel = new JLabel("");
		lblWheel.setIcon(new ImageIcon("Image/Building/Ferris_wheel.png"));
		lblWheel.setBounds(250, 71, 70, 92);
		lblWheel.setVisible(true);

		// create lblHaunted//
		lblHaunted = new JLabel("");
		lblHaunted.setIcon(new ImageIcon("Image/Building/Haunted_House.png"));
		lblHaunted.setBounds(691, 4, 105, 116);
		lblHaunted.setVisible(true);

		// create lblTheater//
		lblTheater = new JLabel("");
		lblTheater.setIcon(new ImageIcon("Image/Building/Theater.png"));
		lblTheater.setBounds(169, 375, 64, 76);
		lblTheater.setVisible(true);

		// create lblCircus//
		lblCircus = new JLabel("");
		lblCircus.setIcon(new ImageIcon("Image/Building/Circus.png"));
		lblCircus.setBounds(30, 348, 112, 203);
		lblCircus.setVisible(true);

		// add label to frame//
		setLayout(null);
		add(time);
		add(fun);
		add(money);
		add(txtTime);
		add(txtFun);
		add(txtMoney);
		add(txtMessageUp);
		add(txtMessageDown);
		add(lblYes);
		add(lblNo);
		add(lblExitYes);
		add(lblExitNo);
		add(lblArrowExit);
		add(txtYes);
		add(txtNo);
		add(SelectYes);
		add(SelectNo);
		add(lblBlack);
		add(lblSnowTown);
		add(lblCave);
		add(lblWheel);
		add(lblHaunted);
		add(lblTheater);
		add(lblCircus);
		
		date = cal.getTime();
		sf = new SimpleDateFormat("hh:mm");
		time.setText(sf.format(date));
		// set timer change every 1s//
		timer = new Timer(2000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tm % 2 == 0)
					tm++;
				else if (tm % 2 != 0)
					tm--;
				lblBlack.setVisible(false);
				lblBg.setVisible(true);

				cal.add(Calendar.MINUTE, 10);
				if (cal.after(calend) == true) {
					try {
						end();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

				updateTime();
				bot01.speed = 1;
				bot02.speed = 1;
				bot03.speed = 1;
			}
		});

		// start timer//
		timer.start();
		setFocusable(true);
		// set background image//
		BackGround();

		// set position//
		player = new Player(411, 558);
		bot01 = new Bot01(388, 212);
		bot02 = new Bot02(142, 490);
		bot03 = new Bot03(106, 258);
		snowtown = new ObjCreator("Image\\Building\\Snow_Town.png", 534, 93, 20, 30, "Snow Town", 180, null);
		cave = new ObjCreator("Image\\Building\\Cave.png", 432, 1, 20, 40, "Cave", 200, null);
		wheel = new ObjCreator("Image\\Building\\Ferris_wheel.png", 250, 71, 40, 15, "Ferris Wheel", 150, null);
		haunted = new ObjCreator("Image\\Building\\Haunted_House.png", 691, 4, 30, 5, "Haunted House", 100, null);
		theater = new ObjCreator("Image\\Building\\Theater.png", 169, 375, 10, 10, "Musical Theater", 120, null);
		circus = new ObjCreator("Image\\Building\\Circus.png", 30, 348, 10, 25, "Circus", 150, null);
		EnterLapas = new ObjCreator("Image\\Building\\EnterLapas.png", 119, 203, 20, 10, "Pedal boat", 80, null);
		EnterTrain = new ObjCreator("Image\\Building\\EnterTrain.png", 66, 265, 30, 20, "Train", 160, null);
		Exit = new ObjCreator("Image\\Building\\Exit.png", 308, 590, 0, 0, "Exit", 0, null);
		Block00 = new BlockCreator("Image\\Block\\00.png", 0, 0);
		Block0200 = new BlockCreator("Image\\Block\\0200.png", 0, 200);
		Block0301 = new BlockCreator("Image\\Block\\0301.png", 0, 301);
		Block0575 = new BlockCreator("Image\\Block\\0575.png", 0, 575);
		Block1910 = new BlockCreator("Image\\Block\\1910.png", 191, 0);
		Block19175 = new BlockCreator("Image\\Block\\19175.png", 191, 75);
		Block3540 = new BlockCreator("Image\\Block\\3540.png", 354, 0);
		Block4770 = new BlockCreator("Image\\Block\\4770.png", 477, 0);
		Block35255 = new BlockCreator("Image\\Block\\35255.png", 35, 255);
		Block61645 = new BlockCreator("Image\\Block\\61645.png", 616, 47);
		Block63287 = new BlockCreator("Image\\Block\\63287.png", 63, 287);
		Block240450 = new BlockCreator("Image\\Block\\240450.png", 240, 450);
		Block269347 = new BlockCreator("Image\\Block\\269347.png", 269, 347);
		Block293551 = new BlockCreator("Image\\Block\\293551.png", 293, 551);
		Block411160 = new BlockCreator("Image\\Block\\411160.png", 411, 160);
		Block473287 = new BlockCreator("Image\\Block\\473287.png", 473, 287);
		Block473301 = new BlockCreator("Image\\Block\\473301.png", 473, 301);
		Block543347 = new BlockCreator("Image\\Block\\543347.png", 543, 347);
		Block648100 = new BlockCreator("Image\\Block\\648100.png", 648, 100);
		Block684120 = new BlockCreator("Image\\Block\\684120.png", 684, 120);
		Block764146 = new BlockCreator("Image\\Block\\764146.png", 764, 146);

		// add listener to player//
		addKeyListener(new Key(player));

		// set & start main timer//
		mainTimer = new Timer(10, this);
		mainTimer.start();
		m = Integer.parseInt(money.getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		// add object to frame//
		super.paint(g);
		g2d = (Graphics2D) g;
		player.draw(g2d);
		bot01.draw(g2d);
		bot02.draw(g2d);
		bot03.draw(g2d);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// update movement//
		player.update();
		bot01.update();
		bot02.update();
		bot03.update();
		// check location between player and object//
		try {
			checkCol();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add update movement//
		repaint();
	}

	// create & add background label//
	public void BackGround() {
		lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon("Image/Page/Design_Map_test.png"));
		lblBg.setBounds(0, 0, 800, 600);
		add(lblBg);
	}

	// check location between player and object//
	public void checkCol() throws Exception {
		if (player.getBoundss().intersects(snowtown.getBounds()) || player.getBoundss().intersects(cave.getBounds())
				|| player.getBoundss().intersects(wheel.getBounds())
				|| player.getBoundss().intersects(haunted.getBounds())
				|| player.getBoundss().intersects(theater.getBounds())
				|| player.getBoundss().intersects(circus.getBounds())
				|| player.getBoundss().intersects(Block00.getBounds())
				|| player.getBoundss().intersects(Block0200.getBounds())
				|| player.getBoundss().intersects(Block0301.getBounds())
				|| player.getBoundss().intersects(Block0575.getBounds())
				|| player.getBoundss().intersects(Block1910.getBounds())
				|| player.getBoundss().intersects(Block19175.getBounds())
				|| player.getBoundss().intersects(Block3540.getBounds())
				|| player.getBoundss().intersects(Block4770.getBounds())
				|| player.getBoundss().intersects(Block35255.getBounds())
				|| player.getBoundss().intersects(Block61645.getBounds())
				|| player.getBoundss().intersects(Block63287.getBounds())
				|| player.getBoundss().intersects(Block240450.getBounds())
				|| player.getBoundss().intersects(Block269347.getBounds())
				|| player.getBoundss().intersects(Block293551.getBounds())
				|| player.getBoundss().intersects(Block411160.getBounds())
				|| player.getBoundss().intersects(Block473287.getBounds())
				|| player.getBoundss().intersects(Block473301.getBounds())
				|| player.getBoundss().intersects(Block543347.getBounds())
				|| player.getBoundss().intersects(Block648100.getBounds())
				|| player.getBoundss().intersects(Block684120.getBounds())
				|| player.getBoundss().intersects(Block764146.getBounds())
				|| player.getBoundss().intersects(bot02.getBoundss())
				) {
			PlaySound.sound4.play();
			blockAll();
		} else if(player.getBoundss().intersects(bot01.getBoundss())){
			bot01.speed = 0;
			PlaySound.sound4.play();
			blockBot();
		} else if(player.getBoundss().intersects(bot03.getBoundss())){
			bot03.speed = 0;
			PlaySound.sound4.play();
			blockBot();
		} 
		else if (player.getBoundss().intersects(lblEnterCave.getBounds())) {
			Walking();
			if (cCheck[0] == 0) {
				txtMessageUp.setText("Do you want enter to");
				txtMessageDown.setText("Cave?");
				lblYes.setVisible(true);
				lblNo.setVisible(true);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int tmp_tm = tm;
						Calendar temp = (Calendar) cal.clone();
						temp.add(Calendar.MINUTE, cave.tl);
						if (cave.c == 0 && temp.getTime().before(calend.getTime()) == true && m - cave.cost > 0) {
							PlaySound.sound1.play();

							if (tmp_tm == tm) {
								lblBg.setVisible(false);
								lblBlack.setVisible(true);
								SelectYes.setVisible(false);
								SelectNo.setVisible(false);
							}
							cave.setTime((Calendar) cal.clone());
							try {
								queue.enqueue(cave);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							cal.add(Calendar.MINUTE, cave.tl);
							cave.hind();

							temp_score_f = cave.fun;
							cave.fun = 0;
							f += temp_score_f;

							temp_score_m = cave.cost;
							cave.cost = 0;
							m -= temp_score_m;
							cCheck[0] = 1;
							PlaySound.sound3.play();
						}
						updateScore();
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					} 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else if (cCheck[0] == 1) {
				txtMessageUp.setText("Thank you.");
				txtMessageDown.setText("");
				txtYes.setText("");
				txtNo.setText("");
				SelectYes.setVisible(false);
				SelectNo.setVisible(false);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(lblEnterCircus.getBounds())) {
			Walking();
			if (cCheck[1] == 0) {
				txtMessageUp.setText("Do you want enter to");
				txtMessageDown.setText("Circus?");
				lblYes.setVisible(true);
				lblNo.setVisible(true);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int tmp_tm = tm;
						Calendar temp = (Calendar) cal.clone();
						temp.add(Calendar.MINUTE, circus.tl);
						if (circus.c == 0 && temp.getTime().before(calend.getTime()) == true && m - circus.cost > 0) {
							PlaySound.sound1.play();

							if (tmp_tm == tm) {
								lblBg.setVisible(false);
								lblBlack.setVisible(true);
								SelectYes.setVisible(false);
								SelectNo.setVisible(false);
							}
							circus.setTime((Calendar) cal.clone());
							try {
								queue.enqueue(circus);

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							cal.add(Calendar.MINUTE, circus.tl);

							circus.hind();

							temp_score_f = circus.fun;
							circus.fun = 0;
							f += temp_score_f;

							temp_score_m = circus.cost;
							circus.cost = 0;
							m -= temp_score_m;
							cCheck[1] = 1;
							PlaySound.sound3.play();
						}
						updateScore();
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					} 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else if (cCheck[1] == 1) {
				txtMessageUp.setText("Thank you.");
				txtMessageDown.setText("");
				txtYes.setText("");
				txtNo.setText("");
				SelectYes.setVisible(false);
				SelectNo.setVisible(false);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(lblEnterHaunted.getBounds())) {
			Walking();
			if (cCheck[2] == 0) {
				txtMessageUp.setText("Do you want enter to");
				txtMessageDown.setText("Haunted House?");
				lblYes.setVisible(true);
				lblNo.setVisible(true);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int tmp_tm = tm;
						Calendar temp = (Calendar) cal.clone();
						temp.add(Calendar.MINUTE, haunted.tl);
						if (haunted.c == 0 && temp.getTime().before(calend.getTime()) == true && m - haunted.cost > 0) {
							PlaySound.sound1.play();

							if (tmp_tm == tm) {
								lblBg.setVisible(false);
								lblBlack.setVisible(true);
								SelectYes.setVisible(false);
								SelectNo.setVisible(false);
							}
							haunted.setTime((Calendar) cal.clone());
							try {
								queue.enqueue(haunted);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							cal.add(Calendar.MINUTE, haunted.tl);
							haunted.hind();

							temp_score_f = haunted.fun;
							haunted.fun = 0;
							f += temp_score_f;

							temp_score_m = haunted.cost;
							haunted.cost = 0;
							m -= temp_score_m;
							cCheck[2] = 1;
							PlaySound.sound3.play();
						}
						updateScore();
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					} 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else if (cCheck[2] == 1) {
				txtMessageUp.setText("Thank you.");
				txtMessageDown.setText("");
				txtYes.setText("");
				txtNo.setText("");
				SelectYes.setVisible(false);
				SelectNo.setVisible(false);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(lblEnterSnow.getBounds())) {
			Walking();
			if (cCheck[3] == 0) {
				txtMessageUp.setText("Do you want enter to");
				txtMessageDown.setText("Snow Town?");
				lblYes.setVisible(true);
				lblNo.setVisible(true);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int tmp_tm = tm;
						Calendar temp = (Calendar) cal.clone();
						temp.add(Calendar.MINUTE, snowtown.tl);
						if (snowtown.c == 0 && temp.getTime().before(calend.getTime()) == true
								&& m - snowtown.cost > 0) {
							PlaySound.sound1.play();

							if (tmp_tm == tm) {
								lblBg.setVisible(false);
								lblBlack.setVisible(true);
								SelectYes.setVisible(false);
								SelectNo.setVisible(false);
							}
							snowtown.setTime((Calendar) cal.clone());
							try {
								queue.enqueue(snowtown);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							cal.add(Calendar.MINUTE, snowtown.tl);
							snowtown.hind();

							temp_score_f = snowtown.fun;
							snowtown.fun = 0;
							f += temp_score_f;

							temp_score_m = snowtown.cost;
							snowtown.cost = 0;
							m -= temp_score_m;
							cCheck[3] = 1;
							PlaySound.sound3.play();
						}
						updateScore();
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					} 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else if (cCheck[3] == 1) {
				txtMessageUp.setText("Thank you.");
				txtMessageDown.setText("");
				txtYes.setText("");
				txtNo.setText("");
				SelectYes.setVisible(false);
				SelectNo.setVisible(false);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(lblEnterTheater.getBounds())) {
			Walking();
			if (cCheck[4] == 0) {
				txtMessageUp.setText("Do you want enter to");
				txtMessageDown.setText("Mucial Theater?");
				lblYes.setVisible(true);
				lblNo.setVisible(true);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int tmp_tm = tm;
						Calendar temp = (Calendar) cal.clone();
						temp.add(Calendar.MINUTE, theater.tl);
						if (theater.c == 0 && temp.getTime().before(calend.getTime()) == true && m - theater.cost > 0) {
							PlaySound.sound1.play();

							if (tmp_tm == tm) {
								lblBg.setVisible(false);
								lblBlack.setVisible(true);
								SelectYes.setVisible(false);
								SelectNo.setVisible(false);
							}
							theater.setTime((Calendar) cal.clone());
							try {
								queue.enqueue(theater);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							cal.add(Calendar.MINUTE, theater.tl);
							theater.hind();

							temp_score_f = theater.fun;
							theater.fun = 0;
							f += temp_score_f;

							temp_score_m = theater.cost;
							theater.cost = 0;
							m -= temp_score_m;
							cCheck[4] = 1;
							PlaySound.sound3.play();
						}
						updateScore();
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					} 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else if (cCheck[4] == 1) {
				txtMessageUp.setText("Thank you.");
				txtMessageDown.setText("");
				txtYes.setText("");
				txtNo.setText("");
				SelectYes.setVisible(false);
				SelectNo.setVisible(false);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(lblEnterWheel.getBounds())) {
			Walking();
			if (cCheck[5] == 0) {
				txtMessageUp.setText("Do you want enter to");
				txtMessageDown.setText("Ferris Wheel?");
				lblYes.setVisible(true);
				lblNo.setVisible(true);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int tmp_tm = tm;
						Calendar temp = (Calendar) cal.clone();
						temp.add(Calendar.MINUTE, wheel.tl);
						if (wheel.c == 0 && temp.getTime().before(calend.getTime()) == true && m - wheel.cost > 0) {
							PlaySound.sound1.play();

							if (tmp_tm == tm) {
								lblBg.setVisible(false);
								lblBlack.setVisible(true);
								SelectYes.setVisible(false);
								SelectNo.setVisible(false);
							}
							wheel.setTime((Calendar) cal.clone());
							try {
								queue.enqueue(wheel);
								wheel.setTime(cal);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							cal.add(Calendar.MINUTE, wheel.tl);
							wheel.hind();

							temp_score_f = wheel.fun;
							wheel.fun = 0;
							f += temp_score_f;

							temp_score_m = wheel.cost;
							wheel.cost = 0;
							m -= temp_score_m;
							cCheck[5] = 1;
							PlaySound.sound3.play();
						}
						updateScore();
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					} 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else if (cCheck[5] == 1) {
				txtMessageUp.setText("Thank you.");
				txtMessageDown.setText("");
				txtYes.setText("");
				txtNo.setText("");
				SelectYes.setVisible(false);
				SelectNo.setVisible(false);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(EnterLapas.getBounds())) {
			Walking();
			if (cCheck[6] == 0) {
				txtMessageUp.setText("Do you want enter to");
				txtMessageDown.setText("Ferris Wheel?");
				lblYes.setVisible(true);
				lblNo.setVisible(true);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int tmp_tm = tm;
						Calendar temp = (Calendar) cal.clone();
						temp.add(Calendar.MINUTE, EnterLapas.tl);
						if (EnterLapas.c == 0 && temp.getTime().before(calend.getTime()) == true
								&& m - EnterLapas.cost > 0) {
							PlaySound.sound1.play();

							if (tmp_tm == tm) {
								lblBg.setVisible(false);
								lblBlack.setVisible(true);
								SelectYes.setVisible(false);
								SelectNo.setVisible(false);
							}
							
							EnterLapas.setTime((Calendar) cal.clone());
							
							try {
								queue.enqueue(EnterLapas);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							cal.add(Calendar.MINUTE, EnterLapas.tl);
							EnterLapas.hind();

							temp_score_f = EnterLapas.fun;
							EnterLapas.fun = 0;
							f += temp_score_f;

							temp_score_m = EnterLapas.cost;
							EnterLapas.cost = 0;
							m -= temp_score_m;
							cCheck[6] = 1;
							PlaySound.sound3.play();
						}
						updateScore();
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					}	 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else if (cCheck[6] == 1) {
				txtMessageUp.setText("Thank you.");
				txtMessageDown.setText("");
				txtYes.setText("");
				txtNo.setText("");
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(EnterTrain.getBounds())) {
			Walking();
			if (cCheck[7] == 0) {
				txtMessageUp.setText("Do you want enter to");
				txtMessageDown.setText("Train?");
				lblYes.setVisible(true);
				lblNo.setVisible(true);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int tmp_tm = tm;
						Calendar temp = (Calendar) cal.clone();
						temp.add(Calendar.MINUTE, EnterTrain.tl);
						if (EnterTrain.c == 0 && temp.getTime().before(calend.getTime()) == true
								&& m - EnterTrain.cost > 0) {
							PlaySound.sound1.play();

							if (tmp_tm == tm) {
								lblBg.setVisible(false);
								lblBlack.setVisible(true);
								SelectYes.setVisible(false);
								SelectNo.setVisible(false);
							}
							EnterTrain.setTime((Calendar) cal.clone());				
							try {
								queue.enqueue(EnterTrain);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							cal.add(Calendar.MINUTE, EnterTrain.tl);
							EnterTrain.hind();

							temp_score_f = EnterTrain.fun;
							EnterTrain.fun = 0;
							f += temp_score_f;

							temp_score_m = EnterTrain.cost;
							EnterTrain.cost = 0;
							m -= temp_score_m;
							cCheck[7] = 1;
							PlaySound.sound3.play();
						}
						updateScore();
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					} 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else if (cCheck[7] == 1) {
				txtMessageUp.setText("Thank you.");
				txtMessageDown.setText("");
				txtYes.setText("");
				txtNo.setText("");
				SelectYes.setVisible(false);
				SelectNo.setVisible(false);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(Exit.getBounds())) {
			Walking();
			if (cCheck[8] == 0) {
				lblArrowExit.setVisible(true);
				if(tm%2==0)
					lblArrowExit.setBounds(407, 561, 45, 45);
				else if(tm%2==1)
					lblArrowExit.setBounds(407, 545, 45, 45);
				txtMessageUp.setText("Do you want exit");
				txtMessageDown.setText("now?");
				lblExitYes.setVisible(true);
				lblExitNo.setVisible(true);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
				txtYes.setText("Yes");
				txtNo.setText("No");
				lblExitYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblExitNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblExitYes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						cCheck[8] = 1;
						int tmp_tm = tm;
						if (tmp_tm == tm) {
							SelectYes.setVisible(false);
							SelectNo.setVisible(false);
						}
						try {
							PlaySound.sound3.play();
							end();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					public void mouseEntered(MouseEvent e) {
						SelectYes.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectYes.setVisible(false);
					}
				});
				lblExitNo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0){
						PlaySound.sound2.play();
					} 
					public void mouseEntered(MouseEvent e) {
						SelectNo.setVisible(true);
					}
					public void mouseExited(MouseEvent e) {
						SelectNo.setVisible(false);
					}
				});
			} else {
				txtMessageUp.setText("Thank you, please");
				txtMessageDown.setText("come back again.");
				SelectYes.setVisible(false);
				SelectNo.setVisible(false);
				lblYes.setVisible(false);
				lblNo.setVisible(false);
			}
		} else if (player.getBoundss().intersects(lblBg.getBounds())) {
			Walking();
			txtMessageUp.setText("");
			txtMessageDown.setText("");
			txtYes.setText("");
			txtNo.setText("");
			lblYes.setVisible(false);
			lblNo.setVisible(false);
			lblExitYes.setVisible(false);
			lblExitNo.setVisible(false);
			lblArrowExit.setVisible(false);
			SelectYes.setVisible(false);
			SelectNo.setVisible(false);
		}
	}

	// end game//
	private void end() throws Exception {
		timer.stop();
		while (cEnd) {
			if (queue.size() > 0) {
				word.append("Item"+"\t"+"Name"+"\t"+"Time in"+"\t"+"Cost"+"\n");
				for (int i = queue.size(); i > 0; i--) {
					ObjCreator a = (ObjCreator) queue.dequeue();
					word.append((j + 1) + "\t" + a.getName() + "\t" + a.getTime() + "\t" + a.getTmpCost() + "\n");
					j++;
					totalCost = totalCost + a.getTmpCost();
				}
				JOptionPane.showMessageDialog(null, new JTextArea(word + "\n\t\t" + "Total Cost" + "\t" + totalCost + "\n\n" + 
				"Thank you, please come back again."));

			} else {
				JOptionPane.showMessageDialog(null, "Don't play anything.");
			}
			cEnd = false;
		}
		RunGUI.frmAmusement.setVisible(true);
		GamePlay.frame.setVisible(false);
	}

	// update score if player intersects object//
	private void updateScore() {
		if (f == 0)
			textFun = "Normal";
		else if (f == 15)
			textFun = "Good";
		else if (f == 30)
			textFun = "Better";
		else if (f == 40)
			textFun = "Great";
		else if (f == 140)
			textFun = "Excellent";
		fun.setText("" + textFun);
		money.setText("" + m);
	}

	private void Walking() {
		player.velX = 0;
		player.velY = 0;
	}

	// Update time label
	public void updateTime() {
		Date date = cal.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
		time.setText(sf.format(date));
	}

	// BlockWall//
	private void blockAll() {
		if (player.key == KeyEvent.VK_UP) {
			player.velX = 0;
			player.velY = player.velY + player.speed + 2;
		} else if (player.key == KeyEvent.VK_LEFT) {
			player.velX = player.velX + player.speed + 2;
			player.velY = 0;
		} else if (player.key == KeyEvent.VK_DOWN) {
			player.velX = 0;
			player.velY = player.velY - player.speed - 2;
		} else if (player.key == KeyEvent.VK_RIGHT) {
			player.velX = player.velX - player.speed - 2;
			player.velY = 0;
		}
	}
	
	// BlockBot//
	private void blockBot(){
		player.velX = 0;
		player.velY = 0;
	}
}