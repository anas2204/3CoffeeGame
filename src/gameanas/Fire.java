package gameanas;

import java.util.Random;

import javax.swing.ImageIcon;

import com.threecoffee.anim.Sprite;

public class Fire extends Sprite {
	
	int time=0;
	
	static final ImageIcon f1 = new ImageIcon("media/fire/fire1.png");
	static final ImageIcon f2 = new ImageIcon("media/fire/fire2.png");
	static final ImageIcon f3 = new ImageIcon("media/fire/fire3.png");
	static final ImageIcon f4 = new ImageIcon("media/fire/fire4.png");
	static final ImageIcon f5 = new ImageIcon("media/fire/fire5.png");
	static final ImageIcon f6 = new ImageIcon("media/fire/fire6.png");
	
	Fire(int x, int y)
	{
		setName("Fire");
		addImage(f1);
		addImage(f2);
		addImage(f3);
		addImage(f4);
		addImage(f5);
		addImage(f6);
		
		setDelay(40);
		setLocation(x, y);		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		
		time+=1;
		
		if(time>=20)
		{
			//Creating a New Villain after Fire stops
			Random r = new Random();
			
			Villain v1 = new Villain(r.nextInt(950), r.nextInt(620));
			v1.addTo(getGameWindow());
			MainWindow.addAnotherVillain(v1);
			v1.play();
			
			this.setVisible(false);
			this.stop();
		}
	}

}
