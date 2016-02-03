/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package gameanas;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;

import com.threecoffee.anim.Actor;
import com.threecoffee.anim.Animation;
import com.threecoffee.anim.Sprite;
import com.threecoffee.control.GameWindow;

/**
 * Represents a stickman character controlled by the player.
 * 
 * @author Divyansh Prakash
 */
public class Villain extends Actor {
	
	public static final ImageIcon s1 = new ImageIcon(
			"media/balls/sprites/player/stand/stand_1.png");
	
	public static final ImageIcon s2 = new ImageIcon(
			"media/balls/sprites/player/stand/stand_2.png");

	public static final ImageIcon die = new ImageIcon("media/balls/sprites/player/die/1.png");
			
	Point p;
	int time = 0;
	
	int xvel,yvel;
	Random r;

	public Villain(int x, int y) {
		setName("villain");
		setLocation(x, y);
		setDelay(70);
		r = new Random();

		Animation[] anims = new Animation[2];

		anims[0] = new Animation();
		anims[0].setName("stand");
		anims[0].setDelay(70);
		anims[0].add(s1);
		anims[0].add(s2);

		anims[1] = new Animation();
		anims[1].setName("die");
		anims[1].add(die);

		addAnimation(anims[0]);
		addAnimation(anims[1]);

		this.setCurrentAnimation(0);
	}

	@Override
	public void collided(Sprite s) {
		// TODO Auto-generated method stub
		super.collided(s);		
	}

	@Override
	public void update() {

		p = MainWindow.getPlayer().getLocation();

		if (time % 1750 == 0) {
			time = 0;
			Ball b = new Ball(getX() + 10, getY() + 10, p.x,
					p.y, 2);

			b.addTo(getGameWindow());
			b.addCollider(MainWindow.getPlayer());
			b.play();
		}

		time += 70;
		
		
		switch (r.nextInt(2)) {
		case 0:
			xvel=5;
			break;
		
		case 1:
			xvel=-5;
			break;
		case 2:
			xvel=0;
			break;
		default:
			break;
		}
		
		switch (r.nextInt(2)) {
		case 0:
			yvel=5;
			break;
		
		case 1:
			yvel=-5;
			break;
		
		case 2:
			yvel=0;
			break;
		default:
			break;
		}
		
		moveSprite(xvel, yvel);
		

		if (getX() > getGameWindow().getWidth() - getWidth())
			setLocation(getGameWindow().getWidth() - getWidth(), getY());
		else if (getX() < 0)
			setLocation(0, getY());
		
		else if(getY()<0)
			setLocation(getX(), 0);
		
		else if(getY()+getHeight()+20>getGameWindow().getHeight())
			setLocation(getX(), getGameWindow().getHeight()-getHeight()-30);
	}

}
