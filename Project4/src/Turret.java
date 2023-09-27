import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

/**
 * This class holds the information needed for Turret
 * @author Mihir Tamrakar
 * Date: 4/4/2022
 *
 */
public class Turret extends JComponent {
	//=============================================Instance Properties=============
	private Rectangle base;
	private Rectangle turret;
	private Color turrentColor;
	//=============================================Methods=============	
	/**
	 * The default constructor that initializes instance properties.
	 */
	public Turret() {
		this.base = new Rectangle(440, 490, 120, 40);
		this.turret = new Rectangle(480, 440, 40, 95);
		this.turrentColor = Color.black;
	}

	/**
	 * This method paints the Turret base and Turret barrel.
	 * @param g is Graphics
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.turrentColor); 
		g.fillRect(this.base.x, this.base.y, this.base.width, 
				this.base.height);
		g.fillRect(this.turret.x, this.turret.y, this.turret.width,
				this.turret.height);
	}
}
