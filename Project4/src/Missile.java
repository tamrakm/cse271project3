import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This class holds the information needed for Missile
 * @author Mihir Tamrakar
 * Date: 4/4/2022
 *
 */
public class Missile extends JComponent {
	//=============================================Instance Properties=============
	private int missileSpeed;
	private Color missileColor;
	//=============================================Methods=============	
	/**
	 * The default constructor that initializes instance properties.
	 */
	public Missile() {
		this.missileSpeed = 6;
		this.missileColor = Color.black;
		super.setBounds(490, 460, 20, 20);

	}
	/**
	 * This method paints the missile
	 * @param g is Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		//g.fillOval(480, 420, 20, 20);
		g.fillOval(super.getX(), super.getY(), super.getWidth(),
				super.getHeight());
	}

	/**
	 * This method determines the next position on the screen the Missile 
	 * should appear on after being repainted. If the missile is off the 
	 * screen the method removes it from the ArrayList. 
	 * @param width
	 * @param height
	 * @param list
	 * @param missile
	 */
	public void move(int width, int height, ArrayList<Missile> list, 
			int missile) {
		if (height < 0) {
			list.remove(missile);
		} else {
			super.setBounds(width, height - missileSpeed, super.getHeight(), 
					super.getWidth());
		}
	}
}

