package game1;

import javax.swing.ImageIcon;

import com.threecoffee.anim.Sprite;
import com.threecoffee.control.GameWindow;

//@author - Anas Siddiqui
public class Demo extends GameWindow {

	Demo() {
		super(600, 400);

		Sprite bg = new Sprite();
		bg.addImage(new ImageIcon("media/paddle/bg.png"));
		bg.setLocation(0, 0);

		Paddle p = new Paddle();
		Ball b = new Ball(2,2);
		Wall leftwall = new Wall(1);
		Wall rightwall = new Wall(1);
		Wall roof = new Wall(2);
		
		
		int brickarr[][] = {
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,0,0,1},
				{1,0,0,0,1,0,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1}
		};
		
		Brick br[][] = new Brick[5][10];
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(brickarr[i][j]==1)
				{
					br[i][j] = new Brick();
					br[i][j].setLocation(100+(br[i][j].getWidth()*j), 50+(br[i][j].getHeight()*i));
					b.addCollider(br[i][j]);
					br[i][j].addTo(this);
					br[i][j].play();
				}
			}
		}
		
		
		b.setLocation(200, 200);
		leftwall.setLocation(0,0);
		roof.setLocation(0, 0);
		rightwall.setLocation(getWidth()-rightwall.getWidth()-5, 0);
			
		b.addCollider(p);
		b.addCollider(leftwall);
		b.addCollider(rightwall);
		b.addCollider(roof);
		
		leftwall.addTo(this);
		roof.addTo(this);
		rightwall.addTo(this);
		
		b.addTo(this);
		p.addTo(this);
		bg.addTo(this);
		
		b.play();
		p.play();
		bg.play();	
		leftwall.play();
		rightwall.play();
		roof.play();

		this.setVisible(true);
	}

	public static void main(String args[]) {
		new Demo();
	}

}
