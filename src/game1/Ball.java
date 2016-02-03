package game1;

import java.math.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.threecoffee.anim.Sprite;
import com.threecoffee.control.GameWindow;

import javax.swing.*;

public class Ball extends Sprite {
	int xvel,yvel;
	long delay=10;
	
	static final ImageIcon brk = new ImageIcon("media/paddle/ball.png");

	Ball(int x, int y) {
		xvel=x;yvel=y;
		setName("Ball");
		addImage(brk);
		setDelay(delay);
	}
	
	@Override
	public void collided(Sprite s) {
		// TODO Auto-generated method stub
		if(s.getName().equals("Paddle"))
		{
			if(getY()>350)
			{
				setLocation(getX(), 350-getHeight()-1);
			}
			
			yvel*=-1;
			if(delay!=1)
			{
				delay-=1;
				System.out.println(delay);
			}
			
			setDelay(delay);
		}
		
		else if (s.getName().equals("Wall"))
		{
			
			if(getX()+getWidth()>600)
				setLocation(200,200);
			
			else if(getX()<0)
				setLocation(0, getY());
			
			xvel*=-1;
		}
		
		else if (s.getName().equals("Roof"))
		{
			if(getY()<0)
				setLocation(getX(), 0);
			
			yvel*=-1;
		}
		
		else if (s.getName().equals("Brick"))
		{
			s.setVisible(false);
			s.stop();			
		}
	}
	
	public void update() {
				
		if(getX()+getWidth()>getGameWindow().getWidth() || getX()<0)
		{
			collided(new Sprite(){
			@Override
			public void setName(String n) {
				// TODO Auto-generated method stub
				setName("Wall");
			}
		});
			return;
		}
		
		if(getY()<0)
		{
		collided(new Sprite(){
			@Override
			public void setName(String n) {
				// TODO Auto-generated method stub
				setName("Roof");
			}
		});
			return;
		}
		
		if(getY()>400)
		{
			setLocation(this.getPreviousLocation().x, 2);
		}
		
		moveSprite(xvel,yvel);
	}
}
