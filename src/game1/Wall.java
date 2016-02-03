package game1;

import javax.swing.ImageIcon;

import com.threecoffee.anim.Sprite;

public class Wall extends Sprite {
	
	Wall(int type)
	{
		if (type==1)
		{
			setName("Wall");
			addImage(new ImageIcon("media/paddle/wall.png"));
			setDelay(9999999);
		}
		
		else if(type==2)
		{
			setName("Roof");
			addImage(new ImageIcon("media/paddle/roof.png"));
			setDelay(9999999);
		}
	}
}
