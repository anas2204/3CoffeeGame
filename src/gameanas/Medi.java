package gameanas;

import javax.swing.ImageIcon;

import com.threecoffee.anim.Sprite;

public class Medi extends Sprite {
	
	public static Medi medikit=null;
	
	static final ImageIcon medi = new ImageIcon("media/health/medi.png");
	public static int time=0;
	
	Medi(int x, int y)
	{
		time=0;
		setName("Medi");
		setLocation(x,y);
		
		addImage(medi);
		setDelay(300);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		time+=1;
		
		if(time>20)
		{
			this.setVisible(false);
			this.stop();
		}
	}

}
