package gameanas;

import javax.swing.ImageIcon;

import com.threecoffee.anim.Sprite;

public class TimerSprite extends Sprite {

	static final ImageIcon timerimage = new ImageIcon("media/health/timer.png");
	
	int timer=0;
	
	public TimerSprite() {
		// TODO Auto-generated constructor stub
		addImage(timerimage);
		setLocation(10, 10);
		setDelay(30);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		
		if(timer<150)
			timer++;
		
		else
		{
			this.setVisible(false);
			this.stop();
		}
	}

}
