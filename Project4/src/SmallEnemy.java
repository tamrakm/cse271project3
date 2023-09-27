import java.awt.Color;
import java.util.ArrayList;

/**
 * This class holds the information needed for SmallEnemy
 * @author Mihir Tamrakar
 * Date: 4/4/2022
 *
 */
public class SmallEnemy extends Enemy {
	//=============================================Methods=============	
	/**
	 * The default constructor that initializes instance properties.
	 */
	public SmallEnemy() {
		super((int) 0, (int) (Math.random() * 400), 15, 
				15, 8);
		setColor();
	}
	//{@inheritDoc}
	@Override
	public void setColor() {
		super.setEnemyColor(new Color((int) (Math.random() * 255), (int)  
				(Math.random() * 255), (int) (Math.random() * 255)));
	}
	//{@inheritDoc}
	@Override
	public void move(int width, int height) {
		if (width < 0 || width > 955) {
			setEnemySpeed(getEnemySpeed() * -1); 
		}
		super.setBounds(width + (int) getEnemySpeed(), height, 
				super.getWidth(), super.getHeight());
	}

	//{@inheritDoc}
	@Override
	public void processCollision(ArrayList<Enemy> list, int enemy) {
		if (list.get(enemy).getHeight() < 0) {
			list.remove(enemy);
		} else {
			super.setBounds(super.getX(), super.getY(), super.getWidth() - 20, 
					super.getHeight() - 20);
		}

	}
}
