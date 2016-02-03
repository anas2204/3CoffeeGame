package gameanas;

import java.awt.event.KeyEvent;

import javax.swing.*;

import com.threecoffee.anim.Sprite;
import com.threecoffee.control.GameWindow;

public class Paddle extends Sprite {

	Paddle() {
		setName("Paddle");
		addImage(new ImageIcon("media/paddle/paddle.png"));
		setLocation(200, 600);
		setDelay(30);
	}

	public void update() {
	}

}
