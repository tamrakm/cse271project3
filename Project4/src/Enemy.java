import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This class holds the information needed for Enemy
 * @author Mihir Tamrakar
 * Date: 4/4/2022
 *
 */
public abstract class Enemy extends JComponent {
	//=============================================Instance Properties=============
	private double enemySpeed;
	private Color enemyColor;
	//=============================================Getters and Setters===========
	/**
	 * Returns the enemySpeed
	 * @return the enemySpeed
	 */
	public double getEnemySpeed() {
		return enemySpeed;
	}

	/**
	 * Sets the enemySpeed
	 * @param enemySpeed the enemySpeed to set
	 */
	public void setEnemySpeed(double enemySpeed) {
		this.enemySpeed = enemySpeed;
	}

	/**
	 * Returns the enemyColor
	 * @return the enemyColor
	 */
	public Color getEnemyColor() {
		return enemyColor;
	}

	/**
	 * Sets the enemyColor
	 * @param enemyColor the enemyColor to set
	 */
	public void setEnemyColor(Color enemyColor) {
		this.enemyColor = enemyColor;
	}
	//=============================================Methods=============	
	/**
	 * A partial constructor that sets the coordinates, size, and speed 
	 * of the Enemy.
	 * @param enemyXCoord
	 * @param enemyYCoord
	 * @param enemyHeight
	 * @param enemyWidth
	 * @param enemySpeed
	 */
	public Enemy(int enemyXCoord, int enemyYCoord, int enemyHeight, 
			int enemyWidth, double enemySpeed) {
		super.setBounds(enemyXCoord, enemyYCoord, enemyWidth, enemyHeight);
		this.enemySpeed = 6.0;
	}

	/**
	 * An abstract method which determines what occurs when a Missile hits an 
		Enemy.
	 * @param list
	 * @param enemy
	 */
	public abstract void processCollision(ArrayList<Enemy> list, int enemy);

	/**
	 * An abstract method which generates and sets the color of the Enemy.
	 */
	public abstract void setColor(); 

	/**
	 * An abstract method which calculates and updates the next position
	 *  of the Enemy
	 * @param width
	 * @param height
	 */
	public abstract void move(int width, int height);
	/**
	 * This method paints the Enemy
	 * @param g is Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(enemyColor);
		g.fillOval(super.getX(), super.getY(), super.getWidth(), 
				super.getHeight());
	}
}
