import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The driver class for Project 4. 
 * Date: 4/14/2022
 * @author Dr. Garrett Goodman and Mihir Tamrakar
 */
public class Tester extends JFrame {
	//=============================================Instance Properties=============
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 600;
	private int score;
	private int timer = 12000;
	private int missilesFired = 0;
	private JLabel scoreLabel = new JLabel("Score" + score);
	private JButton fireButton;
	private GamePanel panel;
	//=============================================Methods=============	
	/**
	 * Default constructor to control the game.
	 */
	public Tester() {

		// Setup the initial JFrame elements
		setTitle("Ball Destruction");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		centerFrame(this); 
		getContentPane().setLayout(new BorderLayout(0,0));


		//JLabel scoreLabel = new JLabel("Score:" + score);
		getContentPane().add(scoreLabel, BorderLayout.NORTH);

		JButton fireButton = new JButton("Shoot the Enemy!");
		fireButton.setPreferredSize(new Dimension(120, 25));
		fireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				panel.addMissile();
				missilesFired++;
			}
		});

		panel = new GamePanel();

		add(panel, BorderLayout.CENTER);
		add(fireButton, BorderLayout.SOUTH);

	}

	/**
	 * This method is called to start the video game which then
	 * calls the infinite game loop for the game.
	 */
	public void start() {

		gameLoop();
	}

	/**
	 * Method contains the game loop to move enemies, manage score,
	 * and check if the game is finished.
	 */
	public void gameLoop() {
		// Game loop
		int counter = 0;
		while(true) {
			counter++;
			pauseGame();
			panel.detectCollision();
			panel.getTotalScore();
			panel.move();
			score = panel.getTotalScore();
			scoreLabel.setText("Score: " + score);
			panel.repaint();
			//Displays if you win or lose
			if (missilesFired > 10) {
				if (panel.getTotalScore() >= 800) {
					scoreLabel.setText("You Win!");
				} else {
					scoreLabel.setText("You Lose!");
				}
				break;
			}
			//Adds an enemy every few loops
			if (counter % 100 == 0 && counter < 800) {
				panel.addEnemy();
			}
		}  
	}

	/**
	 * Pauses the thread for 30ms to control the 
	 * speed of the animations.
	 */
	public void pauseGame() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method centers the frame in the middle of the screen.
	 * 
	 * @param frame to center with respect to the users screen dimensions.
	 */
	public void centerFrame(JFrame frame) {    
		int width = frame.getWidth();
		int height = frame.getHeight();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point center = ge.getCenterPoint();

		int xPosition = center.x - width/2, yPosition = center.y - height/2;
		frame.setBounds(xPosition, yPosition, width, height);
		frame.validate();
	}

	/**
	 * Randomly assign a value to determine how soon a new Enemy should
	 * be created.
	 */
	public void setTimer() {
		timer = (int)(Math.random() * 100);
	}

	/**
	 * The main method to execute the program.
	 * 
	 * @param args Any inputs to the program when it starts.
	 */
	public static void main(String[] args) {
		Tester mainFrame = new Tester();
		mainFrame.setVisible(true);
		mainFrame.start();
	}

}
