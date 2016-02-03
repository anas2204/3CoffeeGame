package gameanas;

import java.awt.event.KeyEvent;
import java.math.*;
import java.util.Random;

import com.threecoffee.anim.Actor;
import com.threecoffee.anim.Sprite;
import com.threecoffee.control.GameWindow;

import javax.swing.*;

public class Ball extends Sprite {
	int xvel,ypos,x1,y1,diff=0,ctr=0;
	float m = 0;
	long delay;
	
	
	static final ImageIcon brk = new ImageIcon("media/paddle/ball.png");
	static final ImageIcon b1 = new ImageIcon("media/balls/sprites/ball/1.png");
	static final ImageIcon b2 = new ImageIcon("media/balls/sprites/ball/2.png");
	static final ImageIcon b3 = new ImageIcon("media/balls/sprites/ball/3.png");

	Ball(int x1, int y1, int x2, int y2, int type) {
		
		//Storing these values to Calculate using Slope Formula of Line
		this.x1 = x1;
		this.y1 = y1;
		diff = y2-y1;
		
		if(x2==x1)
		{
			ctr=1;
			xvel=0;
		}
		
		else
		{
			ctr=0;
			m = (float)(y2-y1)/(x2-x1);
			
			if(m>=1)
				xvel = x2>x1?2:-2;
			
			else if (m>=0 && m<1)
				xvel = x2>x1?4:-4;
				
			else if (m>-1 && m<0)
				xvel = x2>x1?4:-4;
				
			else
				xvel = x2>x1?2:-2;
					
		}
		
		setLocation(x1, y1);
		
		
		//Giving Different delays according to different slopes due to formula used
		if(Math.abs(m)>3)
			delay=50;
		
		else if ((Math.abs(m)>15))
			delay=120;
		
		
		else
			delay=25;
		
		setDelay(delay);
		
		//Ball by main Player Animated
		if(type==1)
		{
			addImage(new ImageIcon("media/balls/sprites/ball/1.png"));
			addImage(new ImageIcon("media/balls/sprites/ball/2.png"));
			addImage(new ImageIcon("media/balls/sprites/ball/3.png"));
			setName("playerball");
		}
			
		//Ball from Villains
		else
		{
			setName("villainball");
			addImage(brk);
		}
	}
	
	@Override
	public void collided(Sprite s) {
		// TODO Auto-generated method stub
		
		//If the Main Villain is hit by a ball of Player
		if(this.getName().equals("playerball") && s.getName().equals("villain"))
		{
			s.setVisible(false);
			s.stop();
			
			Random r = new Random();
			
			//Increasing Score as Killed a Villain
			MainWindow.score+=1;
			
			//Creating Fire where Villain Killed
			Fire f = new Fire(getX()+5, getY()+5);
			f.addTo(getGameWindow());
			f.play();
			
			
			//After every 3 villains killed, Generating a Medical Kit
			if(MainWindow.score%3==0)
			{
				
				if(Medi.medikit!=null && !Medi.medikit.stop)
				{	Medi.time=0;					
				}
				else
				{
					
				Medi.medikit = new Medi(r.nextInt(950),r.nextInt(610));
				Medi.medikit.addTo(getGameWindow());
				Medi.medikit.addCollider(MainWindow.getPlayer());
				Medi.medikit.play();
				}
			}
			
			//After every 7 villains, creating a saver clock
			if(MainWindow.score%7==0)
			{
				ClockSave c1 = new ClockSave();
				c1.addTo(getGameWindow());
				c1.addCollider(MainWindow.getPlayer());
				c1.play();
			}
			
			if(MainWindow.score==5)
			{
				//Creating a New Villain
				
				Villain v1 = new Villain(r.nextInt(950), r.nextInt(620));
				v1.addTo(getGameWindow());
				MainWindow.noofvillains+=1;
				MainWindow.addAnotherVillain(v1);
				v1.play();
			}
			
			this.setVisible(false);
			this.stop();
		}
		
	}
	
	public void update() {
				
		
		if(ctr==0)
		{
			ypos = (int) (m*((getX()+xvel) - x1) + y1);
			setLocation(getX()+xvel,ypos);
		}
		
		else
		{
			{ moveSprite(0, diff>0?1:-1);	}
		}
		
		if(getX()>getGameWindow().getWidth() || getX()<0
				|| getY()<0 || getY()>getGameWindow().getHeight())
		{
			this.setVisible(false);
			this.stop();
		}
	}
}
