/*
 * This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send 
 * a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
 */

package gameanas;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.threecoffee.anim.Actor;
import com.threecoffee.anim.Animation;
import com.threecoffee.anim.Sprite;
import com.threecoffee.control.GameWindow;

import example2_Balls.Game;
import example2_Balls.Highscores;

/**
 * Represents a stickman character controlled by the player.
 * 
 * @author Divyansh Prakash
 */
public class StickMan extends Actor {
	
	public static boolean safe = false;
	
	int timer=0;

	StickMan(int x, int y) {
		setName("player");
		setLocation(x, y);
		
		Animation[] anims = new Animation[4];

		anims[0] = new Animation();
		anims[0].setName("stand");
		anims[0].setDelay(30);
		anims[0].add(new ImageIcon(
				"media/balls/sprites/player/stand/stand_1.png"));
		anims[0].add(new ImageIcon(
				"media/balls/sprites/player/stand/stand_2.png"));

		anims[1] = new Animation();
		anims[1].setName("run_right");
		anims[1].setDelay(30);
		anims[1].add(new ImageIcon(
				"media/balls/sprites/player/run/run_right_1.png"));
		anims[1].add(new ImageIcon(
				"media/balls/sprites/player/run/run_right_2.png"));
		anims[1].add(new ImageIcon(
				"media/balls/sprites/player/run/run_right_3.png"));

		anims[2] = new Animation();
		anims[2].setName("run_left");
		anims[2].setDelay(30);
		anims[2].add(new ImageIcon(
				"media/balls/sprites/player/run/run_left_1.png"));
		anims[2].add(new ImageIcon(
				"media/balls/sprites/player/run/run_left_2.png"));
		anims[2].add(new ImageIcon(
				"media/balls/sprites/player/run/run_left_3.png"));

		anims[3] = new Animation();
		anims[3].setName("die");
		anims[3].add(new ImageIcon("media/balls/sprites/player/die/1.png"));

		addAnimation(anims[0]);
		addAnimation(anims[1]);
		addAnimation(anims[2]);
		addAnimation(anims[3]);

		this.setCurrentAnimation(0);
	}

	@Override
	public void collided(Sprite s) {
		// TODO Auto-generated method stub
		super.collided(s);

		if (s.getName().equals("villainball")) {
			
			if(this.safe)
			{
				s.setVisible(false);
				s.stop();
				return;
			}
			
			if (Health.health == 2) {
				
				getGameWindow().pause(true);
				MainWindow.getPlayer().setVisible(false);
				MainWindow.getPlayer().stop();
				
				getGameWindow().setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(getGameWindow(),"Your Score: "+ MainWindow.score);
				
				System.exit(0);
			}

			Health.health = (Health.health + 1) % 3;
			s.setVisible(false);
			s.stop();
		}

		if (s.getName().equals("Medi")) {
			switch (Health.health) {
			case 1:
				Health.health = 0;
				break;
			case 2:
				Health.health = 1;
				break;
			}

			s.setVisible(false);
			s.stop();
		}
		
		if(s.getName().equals("clock"))
		{
			this.safe=true;
			
			TimerSprite ts = new TimerSprite();
			ts.addTo(getGameWindow());
			ts.play();
			
			s.setVisible(false);
			s.stop();
		}

	}

	@Override
	public void update() {
		
		if(safe && timer<150)
		{
			timer++;
		}
		
		else
		{
			timer=0;
			safe=false;
		}			
		

		if (GameWindow.isKeyDown(KeyEvent.VK_D)) {
			moveSprite(15, 0);
			setCurrentAnimation(1);
		} else if (GameWindow.isKeyDown(KeyEvent.VK_A)) {
			moveSprite(-15, 0);
			setCurrentAnimation(2);
		}

		else if (GameWindow.isKeyDown(KeyEvent.VK_W)) {
			moveSprite(0, -15);
			setCurrentAnimation(0);
		}

		else if (GameWindow.isKeyDown(KeyEvent.VK_S)) {
			moveSprite(0, +15);
			setCurrentAnimation(0);
		}

		else
			setCurrentAnimation(0);

		if (getX() > getGameWindow().getWidth() - getWidth())
			setLocation(getGameWindow().getWidth() - getWidth(), getY());
		else if (getX() < 0)
			setLocation(0, getY());
		else if (getY() < 0)
			setLocation(getX(), 0);

		else if (getY() + getHeight() + 20 > getGameWindow().getHeight())
			setLocation(getX(), getGameWindow().getHeight() - getHeight() - 30);
	}

}
