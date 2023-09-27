import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * This class contains the paintable objects such as the enemies,
 * turret, and missile. It also keeps track of the 
 * Date: 4/14/2022
 * @author Dr. Garrett Goodman and Mihir Tamrakar
 */
public class GamePanel extends JPanel {
	//=============================================Instance Properties=============
	private int totalScore;
	private boolean isNextEnemyBig;
	private Turret turret;
	private ArrayList<Enemy> enemyList;
	private ArrayList<Missile> missileList; 
	//=============================================Methods=============	
	/**
	 * The default constructor that initializes instance properties.
	 */
	public GamePanel() {
		this.totalScore = 0;
		this.isNextEnemyBig = false;
		this.turret = new Turret();
		this.enemyList = new ArrayList<Enemy>();
		this.missileList = new ArrayList<Missile>();

		enemyList.add(new BigEnemy());
		enemyList.add(new SmallEnemy());
	}

	/**
	 * Calls the corresponding move method
	 */
	public void move() {
		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).move(enemyList.get(i).getX(), enemyList.get(i).getY());
		}
		for (int j = 0; j < missileList.size(); j++) {
			missileList.get(j).move(missileList.get(j).getX(), missileList.get(j).getY(), missileList, j);
		}
	}

	/**
	 * Adds a new Missile to the ArrayList Missile
	 */
	public void addMissile() {
		missileList.add(new Missile());
	}
	/**
	 * Adds a new Enemy to the ArrayList Enemy based of the isNextEnemyBig
	 */
	public void addEnemy() {
		if (isNextEnemyBig) {
			enemyList.add(new BigEnemy());
			isNextEnemyBig = false;
		} else {
			enemyList.add(new SmallEnemy());
			isNextEnemyBig = true;
		}
	}
	/**
	 * Returns the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * Paints the enemies and missiles when called and also paints
	 * the background of the panel White.
	 */
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.setColor(Color.white); 
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); 

		for (int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).paintComponent(g);
		}
		for (int i = 0; i < missileList.size(); i++) {
			missileList.get(i).paintComponent(g);
		}

		turret.paintComponent(g);

	} 

	/**
	 * Method detects the collision of the missile and all the enemies. This is done by
	 * drawing invisible rectangles around the enemies and missiles, if they intersect, then 
	 * they collide.
	 */
	public void detectCollision() {
		// Create temporary rectangles for every enemy and missile on the screen currently       
		for(int i = 0; i < enemyList.size(); i++) {
			Rectangle enemyRec = enemyList.get(i).getBounds();
			for(int j = 0; j < missileList.size(); j++) {
				Rectangle missileRec = missileList.get(j).getBounds();
				if(missileRec.intersects(enemyRec)) {
					(enemyList.get(i)).processCollision(enemyList, i);
					missileList.remove(j); 
					if(enemyList.get(i) instanceof BigEnemy) {
						totalScore += 100;
					} else {
						totalScore += 150;
					}
				}
			}
		}
	}

}
