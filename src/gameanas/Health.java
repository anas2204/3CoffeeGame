package gameanas;

import javax.swing.ImageIcon;

import com.threecoffee.anim.Sprite;

public class Health extends Sprite {
	
	public static int health = 0;
	
	static final ImageIcon h1 = new ImageIcon("media/health/h1.png");
	static final ImageIcon h2 = new ImageIcon("media/health/h2.png");
	static final ImageIcon h3 = new ImageIcon("media/health/h3.png");
	
	Health()
	{
		setName("health");
		setLocation(MainWindow.getPlayer().getX()-15, MainWindow.getPlayer().getY() - 20);
		
		addImage(h3);
		addImage(h1);
		addImage(h2);
		
		
		setDelay(50);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();		
		this.setCurrentSpriteIndex(health);
		
		setLocation(MainWindow.getPlayer().getX()-15, MainWindow.getPlayer().getY() - 20);
	}

}
