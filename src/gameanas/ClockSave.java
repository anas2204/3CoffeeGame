package gameanas;

import java.util.Random;

import javax.swing.ImageIcon;

import com.threecoffee.anim.Sprite;
import com.threecoffee.util.Logger;

public class ClockSave extends Sprite {

	static final ImageIcon h1 = new ImageIcon("media/health/rsz_media.jpg");
	int time = 0;

	public ClockSave() {
		// TODO Auto-generated constructor stub
		addImage(h1);
		setName("clock");
		setDelay(200);
		Random r = new Random();

		setLocation(r.nextInt(900), r.nextInt(620));
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();

			if (time > 30) {
				this.setVisible(false);
				this.stop();
			}
		}
	}


