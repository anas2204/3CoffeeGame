package game1;

import java.awt.event.KeyEvent;

import javax.swing.*;

import com.threecoffee.anim.Sprite;
import com.threecoffee.control.GameWindow;

public class Paddle extends Sprite {

	Paddle() {
		setName("Paddle");
		addImage(new ImageIcon("media/paddle/paddle.png"));
		setLocation(200, 350);
		setDelay(30);
	}

	public void update() {
		if (GameWindow.isKeyDown(KeyEvent.VK_LEFT) && getX()>5) {
			moveSprite(-10, 0);
		}
		if (GameWindow.isKeyDown(KeyEvent.VK_RIGHT) && getX()+getWidth()<getGameWindow().getWidth()) {
			moveSprite(10, 0);
		}
		
		
	}

}
